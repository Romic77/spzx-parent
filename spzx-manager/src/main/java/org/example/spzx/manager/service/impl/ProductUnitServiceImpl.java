package org.example.spzx.manager.service.impl;

import org.checkerframework.checker.units.qual.A;
import org.example.spzx.manager.mapper.ProductUnitMapper;
import org.example.spzx.manager.service.ProductUnitService;
import org.example.spzx.model.entity.base.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    @Autowired
    private ProductUnitMapper productUnitMapper;

    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll();
    }
}
