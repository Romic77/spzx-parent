package org.example.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import org.example.spzx.manager.service.CategoryBrandService;
import org.example.spzx.model.dto.product.CategoryBrandDto;
import org.example.spzx.model.entity.product.Brand;
import org.example.spzx.model.entity.product.CategoryBrand;
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

import java.util.List;

@RestController
@RequestMapping(value = "/admin/product/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService ;

    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<CategoryBrand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit, CategoryBrandDto CategoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findByPage(page, limit, CategoryBrandDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("/save")
    public Result save(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.save(categoryBrand);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @PutMapping("updateById")
    public Result updateById(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.updateById(categoryBrand);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        categoryBrandService.deleteById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping("/findBrandByCategoryId/{categoryId}")
    public Result findBrandByCategoryId(@PathVariable Long categoryId) {
        List<Brand> brandList =   categoryBrandService.findBrandByCategoryId(categoryId);
        return Result.build(brandList , ResultCodeEnum.SUCCESS) ;
    }
}