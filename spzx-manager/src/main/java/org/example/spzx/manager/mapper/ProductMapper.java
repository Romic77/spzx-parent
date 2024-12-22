package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.product.ProductDto;
import org.example.spzx.model.entity.product.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> findByPage(ProductDto productDto);

    void save(Product product);

    Product selectById(Long id);

    void updateById(Product product);
}