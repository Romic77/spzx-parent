package org.example.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import org.example.spzx.model.entity.product.Brand;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface BrandService {
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    void save(Brand brand);

    void updateById(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}
