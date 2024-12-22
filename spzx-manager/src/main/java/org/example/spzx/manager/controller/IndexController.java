package org.example.spzx.manager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.spzx.manager.service.SysUserService;
import org.example.spzx.manager.service.ValidateCodeService;
import org.example.spzx.model.dto.system.LoginDto;
import org.example.spzx.model.entity.system.SysUser;
import org.example.spzx.model.vo.common.Result;
import org.example.spzx.model.vo.common.ResultCodeEnum;
import org.example.spzx.model.vo.system.LoginVo;
import org.example.spzx.model.vo.system.ValidateCodeVo;
import org.example.spzx.utils.AuthContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Tag(name = "用户接口", description = "用户接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;


    @PostMapping(value = "/login")
    @Operation(summary = "登录接口", description = "登录接口")
    public Result<LoginVo> index(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto) ;
        return Result.build(loginVo, ResultCodeEnum.SUCCESS);
    }

    @GetMapping(value = "/generateValidateCode")
    @Operation(summary = "生成验证码接口", description = "生成验证码接口")
    public Result generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping(value = "/getUserInfo")
    @Operation(summary = "获取用户信息接口", description = "获取用户信息接口")
    public Result<SysUser> getUserInfo(@RequestHeader(name = "token") String token) {
        SysUser sysUser = sysUserService.getUserInfo(token) ;
        return Result.build(AuthContextUtil.getAuthContext(), ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping(value = "/logout")
    @Operation(summary = "退出登录接口", description = "退出登录接口")
    public Result logout(@RequestHeader(value = "token") String token) {
        sysUserService.logout(token) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
