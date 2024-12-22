package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.system.SysUserDto;
import org.example.spzx.model.entity.system.SysUser;

import java.util.List;

public interface SysUserMapper {

    /**
     * 根据用户名查询用户数据
     * @param userName
     * @return
     */
    public abstract SysUser selectByUserName(String userName) ;

    /**
     * @Description: 用户条件分页查询接口
     * @param sysUserDto
     */
    List<SysUser> findByPage(SysUserDto sysUserDto);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteById(Long userId);
}