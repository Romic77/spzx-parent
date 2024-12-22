package org.example.spzx.manager.mapper;

import org.example.spzx.model.dto.order.OrderStatisticsDto;
import org.example.spzx.model.entity.order.OrderStatistics;

import java.util.List;

public interface OrderStatisticsMapper {
    List<OrderStatistics> selectList(OrderStatisticsDto orderStatisticsDto);

    void insert(OrderStatistics orderStatistics);
}