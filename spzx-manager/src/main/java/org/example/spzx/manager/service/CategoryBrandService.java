package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.dto.product.CategoryBrandDto;
import org.example.spzx.model.entity.product.Brand;
import org.example.spzx.model.entity.product.CategoryBrand;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface CategoryBrandService {
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);

    void save(CategoryBrand categoryBrand);

    void updateById(CategoryBrand categoryBrand);

    void deleteById(Long id);

    List<Brand> findBrandByCategoryId(Long categoryId);
}
