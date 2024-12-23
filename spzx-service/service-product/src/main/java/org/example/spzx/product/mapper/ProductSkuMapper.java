package org.example.spzx.product.mapper;

import org.example.spzx.model.entity.product.ProductSku;

import java.util.List;

public interface ProductSkuMapper {

    List<ProductSku> findProductSkuBySale();
}