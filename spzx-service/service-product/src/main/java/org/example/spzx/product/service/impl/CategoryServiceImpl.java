package org.example.spzx.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.example.spzx.model.entity.product.Category;
import org.example.spzx.product.mapper.CategoryMapper;
import org.example.spzx.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Romic
 * @date 2024/12/23
 * @description
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findOneCategory() {
        return categoryMapper.findOneCategory();
    }

    @Cacheable(value = "category", key = "'all'")
    @Override
    public List<Category> findCategoryTree() {
        List<Category> categoryList = categoryMapper.findAll();

        List<Category> oneCategoryList = categoryList.stream().filter(item -> item.getParentId() == 0).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(oneCategoryList)) {
            oneCategoryList.forEach(oneCategory -> {
                List<Category> twoCategoryList = categoryList.stream().filter(child -> child.getParentId().equals(oneCategory.getId())).collect(Collectors.toList());
                oneCategory.setChildren(twoCategoryList);

                if (CollUtil.isNotEmpty(twoCategoryList)) {
                    twoCategoryList.forEach(twoCategory -> {
                        List<Category> threeCategoryList = categoryList.stream().filter(child -> child.getParentId().equals(twoCategory.getId())).collect(Collectors.toList());
                        twoCategory.setChildren(threeCategoryList);
                    });
                }
            });

        }
        return oneCategoryList;
    }
}
