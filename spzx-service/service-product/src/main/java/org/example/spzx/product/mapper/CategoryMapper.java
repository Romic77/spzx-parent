package org.example.spzx.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.spzx.model.entity.product.Category;

import java.util.List;

public interface CategoryMapper {

    List<Category> findOneCategory();

    List<Category> findAll();
}