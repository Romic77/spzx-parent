package org.example.spzx.manager.mapper;

import org.example.spzx.model.entity.order.OrderStatistics;

public interface OrderInfoMapper {

    // 查询指定日期产生的订单数据
    public abstract OrderStatistics selectOrderStatistics(String creatTime);

}