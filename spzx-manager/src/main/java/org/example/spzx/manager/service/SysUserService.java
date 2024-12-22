package org.example.spzx.manager.service;

import org.example.spzx.model.dto.system.LoginDto;
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
}
