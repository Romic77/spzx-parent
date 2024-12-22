package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.dto.system.AssginRoleDto;
import org.example.spzx.model.dto.system.LoginDto;
import org.example.spzx.model.dto.system.SysUserDto;
import org.example.spzx.model.entity.system.SysUser;
import org.example.spzx.model.vo.system.LoginVo;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface SysUserService {
    /**
     * 根据用户名查询用户数据
     *
     * @return
     */
    public LoginVo login(LoginDto loginDto);

    public SysUser getUserInfo(String token);

    public void logout(String token);

    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteById(Long userId);

    void doAssign(AssginRoleDto assginRoleDto);
}
