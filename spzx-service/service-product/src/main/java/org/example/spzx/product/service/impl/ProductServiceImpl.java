package org.example.spzx.product.service.impl;

import org.example.spzx.model.entity.product.ProductSku;
import org.example.spzx.product.mapper.ProductSkuMapper;
import org.example.spzx.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/23
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Override
    public List<ProductSku> findProductSkuListBySale() {
        return productSkuMapper.findProductSkuBySale();
    }
}
