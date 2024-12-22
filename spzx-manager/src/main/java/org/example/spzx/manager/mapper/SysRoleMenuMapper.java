package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.system.AssginMenuDto;

import java.util.List;

public interface SysRoleMenuMapper {
    public  List<Long> findSysRoleMenuByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}