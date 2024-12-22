package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.entity.product.ProductSpec;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface ProductSpecService {
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    void save(ProductSpec productSpec);

    void updateById(ProductSpec productSpec);

    void deleteById(Long id);

    List<ProductSpec> findAll();
}
