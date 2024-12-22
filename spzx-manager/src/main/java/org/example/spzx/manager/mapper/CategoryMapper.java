package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.product.Category;
import org.example.spzx.model.vo.product.CategoryExcelVo;

import java.util.List;

public interface CategoryMapper {
    public List<Category> selectByParentId(Long parentId);

    public int countByParentId(Long id);

    List<Category> selectAll();

    void batchInsert(List<CategoryExcelVo> cachedDataList);
}