package org.example.spzx.manager.service;

import org.example.spzx.model.entity.system.SysMenu;
import org.example.spzx.model.vo.system.SysMenuVo;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface SysMenuService {
    List<SysMenu> findNodes();

    void save(SysMenu sysMenu);

    void updateById(SysMenu sysMenu);

    void removeById(Long id);

    List<SysMenuVo> findUserMenuList();
}
