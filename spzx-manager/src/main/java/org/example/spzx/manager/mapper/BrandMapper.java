package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.product.Brand;

import java.util.List;

public interface BrandMapper {
    public abstract List<Brand> findByPage();

    void save(Brand brand);

    void updateById(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}