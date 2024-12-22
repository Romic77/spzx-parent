package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.system.SysRoleDto;
import org.example.spzx.model.entity.system.SysRole;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface SysRoleMapper {
    public List<SysRole> findByPage(SysRoleDto sysRoleDto);

    void saveSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    void deleteById(Long roleId);

    List<SysRole> findAllRoles();
}
