package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.product.ProductSpec;

import java.util.List;

public interface ProductSpecMapper {
    public  List<ProductSpec> findByPage();

    void save(ProductSpec productSpec);

    void updateById(ProductSpec productSpec);

    void deleteById(Long id);

    List<ProductSpec> findAll();
}