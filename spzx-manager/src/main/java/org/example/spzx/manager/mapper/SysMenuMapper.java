package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.system.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    public List<SysMenu> selectAll();

    void insert(SysMenu sysMenu);

    void updateById(SysMenu sysMenu);

    int countByParentId(Long id);

    void deleteById(Long id);

    List<SysMenu> selectListByUserId(Long userId);
}