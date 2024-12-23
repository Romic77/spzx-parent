package org.example.spzx.product.service;

import org.example.spzx.model.entity.product.ProductSku;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/23
 * @description
 */
public interface ProductService {
    List<ProductSku> findProductSkuListBySale();
}
