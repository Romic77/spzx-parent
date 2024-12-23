package org.example.spzx.product.service;

import org.example.spzx.model.entity.product.Category;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/23
 * @description
 */
public interface CategoryService {
    List<Category> findOneCategory();

    List<Category> findCategoryTree();
}
