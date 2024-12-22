package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.product.CategoryBrandDto;
import org.example.spzx.model.entity.product.Brand;
import org.example.spzx.model.entity.product.CategoryBrand;

import java.util.List;

public interface CategoryBrandMapper {
    public abstract List<CategoryBrand> findByPage(CategoryBrandDto CategoryBrandDto);

    void save(CategoryBrand categoryBrand);

    void updateById(CategoryBrand categoryBrand);

    void deleteById(Long id);

    List<Brand> findBrandByCategoryId(Long categoryId);
}