package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.dto.product.ProductDto;
import org.example.spzx.model.entity.product.Product;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface ProductService {
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    void save(Product product);

    Product getById(Long id);

    void updateById(Product product);

    void updateAuditStatus(Long id, Integer auditStatus);

    void updateStatus(Long id, Integer status);
}
