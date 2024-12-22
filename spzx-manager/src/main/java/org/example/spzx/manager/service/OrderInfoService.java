package org.example.spzx.manager.service;

import org.example.spzx.model.dto.order.OrderStatisticsDto;
import org.example.spzx.model.vo.order.OrderStatisticsVo;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface OrderInfoService {
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
