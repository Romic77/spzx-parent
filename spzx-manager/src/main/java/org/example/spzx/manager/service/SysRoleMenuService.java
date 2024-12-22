package org.example.spzx.manager.service;

import org.example.spzx.model.dto.system.AssginMenuDto;

import java.util.Map;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface SysRoleMenuService {
    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}
