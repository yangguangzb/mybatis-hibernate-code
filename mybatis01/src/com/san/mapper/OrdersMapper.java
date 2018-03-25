package com.san.mapper;
import java.util.List;

import com.san.po.OrdersExt;
public interface OrdersMapper {
	//延迟加载
	public List<OrdersExt> findOrderAndUserLazyLoading();
}
