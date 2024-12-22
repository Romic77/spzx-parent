package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.dto.system.SysRoleDto;
import org.example.spzx.model.entity.system.SysRole;

import java.util.Map;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface SysRoleService {
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, int pageNum, int pageSize);

    void saveSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    void deleteById(Long roleId);

    Map<String, Object> findAllRoles();

    Map<String, Object> findAllRoles(Long userId);
}
