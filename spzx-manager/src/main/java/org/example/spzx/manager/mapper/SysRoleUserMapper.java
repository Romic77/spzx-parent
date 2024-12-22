package org.example.spzx.manager.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleUserMapper {

    public void doAssign(@Param("userId") Long userId,
                         @Param("roleId") Long roleId);        // 添加关联关系

    public void deleteByUserId(Long userId);                // 根据用户的id删除数据

    List<Long> findSysUserRoleByUserId(Long userId);
}