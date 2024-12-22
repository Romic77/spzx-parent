package org.example.spzx.manager.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.example.spzx.manager.service.CategoryService;
import org.example.spzx.model.entity.product.Category;
import org.example.spzx.model.vo.common.Result;
import org.example.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value="/admin/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "根据parentId获取下级节点")
    @GetMapping(value = "/findByParentId/{parentId}")
    public Result<List<Category>> findByParentId(@PathVariable Long parentId) {
        List<Category> list = categoryService.findByParentId(parentId);
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        categoryService.importData(file);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        categoryService.exportData(response);
    }
}