package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.product.ProductDetails;

public interface ProductDetailsMapper {
    public  void save(ProductDetails productDetails);

    ProductDetails selectByProductId(Long id);

    void updateById(ProductDetails productDetails);
}