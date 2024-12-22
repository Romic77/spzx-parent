package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.product.ProductSku;

import java.util.List;

public interface ProductSkuMapper {
    public  void save(ProductSku productSku);

    List<ProductSku> selectByProductId(Long id);

    void updateById(ProductSku productSku);
}