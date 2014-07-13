package com.ort.bodsp.wslog.dao;

import com.ort.bodsp.core.dao.BaseDao;
import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.po.Orders;
import com.ort.bodsp.wslog.vo.OrdersParam;

public interface OrdersDao extends BaseDao<Orders>{

	Pagination<Orders> queryForPage(OrdersParam param);

}
