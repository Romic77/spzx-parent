package org.example.spzx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.spzx.manager.mapper.SysRoleMapper;
import org.example.spzx.manager.mapper.SysRoleUserMapper;
import org.example.spzx.manager.service.SysRoleService;
import org.example.spzx.model.dto.system.SysRoleDto;
import org.example.spzx.model.entity.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper ;

    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> sysRoleList = sysRoleMapper.findByPage(sysRoleDto);
        return new PageInfo(sysRoleList);
    }

    @Override
    public void saveSysRole(SysRole sysRole) {
        sysRoleMapper.saveSysRole(sysRole);
    }

    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.updateSysRole(sysRole);
    }

    @Override
    public void deleteById(Long roleId) {
        sysRoleMapper.deleteById(roleId) ;
    }

    @Override
    public Map<String, Object> findAllRoles() {
        List<SysRole> sysRoleList = sysRoleMapper.findAllRoles() ;
        Map<String , Object> resultMap = new HashMap<>() ;
        resultMap.put("allRolesList" , sysRoleList) ;
        return resultMap;
    }

    @Override
    public Map<String, Object> findAllRoles(Long userId) {
        // 查询所有的角色数据
        List<SysRole> sysRoleList = sysRoleMapper.findAllRoles() ;

        // 查询当前登录用户的角色数据
        List<Long> sysRoles = sysRoleUserMapper.findSysUserRoleByUserId(userId);

        // 构建响应结果数据
        Map<String , Object> resultMap = new HashMap<>() ;
        resultMap.put("allRolesList" , sysRoleList) ;
        resultMap.put("sysUserRoles", sysRoles);

        return resultMap;
    }
}
