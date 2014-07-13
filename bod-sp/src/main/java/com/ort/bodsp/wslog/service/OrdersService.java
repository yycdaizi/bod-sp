package com.ort.bodsp.wslog.service;

import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.po.Orders;
import com.ort.bodsp.wslog.vo.OrdersParam;

public interface OrdersService {

	Pagination<Orders> queryForPage(OrdersParam param);

}
