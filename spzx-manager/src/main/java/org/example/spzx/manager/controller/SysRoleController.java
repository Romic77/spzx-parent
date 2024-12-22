package org.example.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.spzx.log.annotation.Log;
import org.example.spzx.manager.service.SysRoleService;
import org.example.spzx.model.dto.system.SysRoleDto;
import org.example.spzx.model.entity.system.SysRole;
import org.example.spzx.model.vo.common.Result;
import org.example.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Tag(name = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(@RequestBody SysRoleDto sysRoleDto, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return Result.build(sysRoleService.findByPage(sysRoleDto, pageNum, pageSize), ResultCodeEnum.SUCCESS);
    }

    @Log(title = "角色添加",businessType = 0) //添加Log注解，设置属性
    @PostMapping(value = "/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole SysRole) {
        sysRoleService.saveSysRole(SysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.updateSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @DeleteMapping(value = "/deleteById/{roleId}")
    public Result deleteById(@PathVariable(value = "roleId") Long roleId) {
        sysRoleService.deleteById(roleId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping(value = "/findAllRoles")
    public Result<Map<String , Object>> findAllRoles() {
        Map<String, Object> resultMap = sysRoleService.findAllRoles();
        return Result.build(resultMap , ResultCodeEnum.SUCCESS)  ;
    }

    @GetMapping(value = "/findAllRoles/{userId}")
    public Result<Map<String , Object>> findAllRoles(@PathVariable(value = "userId") Long userId) {
        Map<String, Object> resultMap = sysRoleService.findAllRoles(userId);
        return Result.build(resultMap , ResultCodeEnum.SUCCESS)  ;
    }

}
