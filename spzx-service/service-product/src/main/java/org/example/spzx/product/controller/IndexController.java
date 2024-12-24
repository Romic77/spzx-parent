package org.example.spzx.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.spzx.model.entity.product.Category;
import org.example.spzx.model.entity.product.ProductSku;
import org.example.spzx.model.vo.common.Result;
import org.example.spzx.model.vo.common.ResultCodeEnum;
import org.example.spzx.model.vo.h5.IndexVo;
import org.example.spzx.product.service.CategoryService;
import org.example.spzx.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/23
 * @description
 */
@Tag(name = "首页接口管理")
@RestController
@RequestMapping(value="/product/index")
public class IndexController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Operation(summary = "获取首页数据")
    @GetMapping
    public Result<IndexVo> findData(){
        //查询一级分类列表
        List<Category> categoryList = categoryService.findOneCategory();
        //查询畅销商品列表
        List<ProductSku> productSkuList = productService.findProductSkuListBySale();
        IndexVo indexVo = new IndexVo();
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo, ResultCodeEnum.SUCCESS);
    }
}
