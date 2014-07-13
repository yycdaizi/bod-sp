package com.ort.bodsp.wslog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.dao.OrdersDao;
import com.ort.bodsp.wslog.po.Orders;
import com.ort.bodsp.wslog.service.OrdersService;
import com.ort.bodsp.wslog.vo.OrdersParam;

@Transactional
@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public Pagination<Orders> queryForPage(OrdersParam param) {
		return ordersDao.queryForPage(param);
	}

}
