package org.example.spzx.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.spzx.common.exception.GuiguException;
import org.example.spzx.manager.mapper.SysRoleUserMapper;
import org.example.spzx.manager.mapper.SysUserMapper;
import org.example.spzx.manager.service.SysUserService;
import org.example.spzx.model.dto.system.AssginRoleDto;
import org.example.spzx.model.dto.system.LoginDto;
import org.example.spzx.model.dto.system.SysUserDto;
import org.example.spzx.model.entity.system.SysUser;
import org.example.spzx.model.vo.common.ResultCodeEnum;
import org.example.spzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper ;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper ;

    @Autowired
    private RedisTemplate<String , String> redisTemplate ;

    @Override
    public LoginVo login(LoginDto loginDto) {
        // 校验验证码是否正确
        String captcha = loginDto.getCaptcha();     // 用户输入的验证码
        String codeKey = loginDto.getCodeKey();     // redis中验证码的数据key

        // 从Redis中获取验证码
        String redisCode = redisTemplate.opsForValue().get("user:login:validatecode:" + codeKey);
        if(StrUtil.isEmpty(redisCode) || !StrUtil.equalsIgnoreCase(redisCode , captcha)) {
            //验证码错误
            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR) ;
        }

        // 验证通过删除redis中的验证码
        redisTemplate.delete("user:login:validatecode:" + codeKey) ;

        // 根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        if(sysUser == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }

        // 验证密码是否正确
        String inputPassword = loginDto.getPassword();
        String md5InputPassword = DigestUtils.md5DigestAsHex(inputPassword.getBytes());
        if(!md5InputPassword.equals(sysUser.getPassword())) {
            throw new RuntimeException("用户名或者密码错误") ;
        }

        // 生成令牌，保存数据到Redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("user:login:" + token , JSON.toJSONString(sysUser) , 30 , TimeUnit.MINUTES);

        // 构建响应结果对象
        LoginVo loginVo = new LoginVo() ;
        loginVo.setToken(token);
        loginVo.setRefresh_token("");

        // 返回
        return loginVo;
    }

    @Override
    public SysUser getUserInfo(String token) {
        String userJson = redisTemplate.opsForValue().get("user:login:" + token);
        return JSON.parseObject(userJson , SysUser.class) ;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:" + token) ;
    }

    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<SysUser> sysUserList = sysUserMapper.findByPage(sysUserDto) ;
        return new PageInfo(sysUserList) ;
    }

    @Override
    public void saveSysUser(SysUser sysUser) {
        // 根据输入的用户名查询用户
        SysUser dbSysUser = sysUserMapper.findByUserName(sysUser.getUserName()) ;
        if(dbSysUser != null) {
            throw new GuiguException(ResultCodeEnum.USER_NAME_IS_EXISTS) ;
        }

        // 对密码进行加密
        String password = sysUser.getPassword();
        String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        sysUser.setPassword(digestPassword);
        sysUser.setStatus(1);
        sysUserMapper.saveSysUser(sysUser) ;
    }

    @Override
    public void updateSysUser(SysUser sysUser) {
        sysUserMapper.updateSysUser(sysUser) ;
    }

    @Override
    public void deleteById(Long userId) {
        sysUserMapper.deleteById(userId) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAssign(AssginRoleDto assginRoleDto) {
        // 删除之前的所有的用户所对应的角色数据
        sysRoleUserMapper.deleteByUserId(assginRoleDto.getUserId()) ;

        // 分配新的角色数据
        List<Long> roleIdList = assginRoleDto.getRoleIdList();
        roleIdList.forEach(roleId->{
            sysRoleUserMapper.doAssign(assginRoleDto.getUserId(),roleId);
        });
    }
}
