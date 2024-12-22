package org.example.spzx.manager.service;

import jakarta.servlet.http.HttpServletResponse;
import org.example.spzx.model.entity.product.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface CategoryService {
    List<Category> findByParentId(Long parentId);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
