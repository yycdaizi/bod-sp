package com.ort.bodsp.wslog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ort.bodsp.core.vo.GridPage;
import com.ort.bodsp.wslog.po.Orders;
import com.ort.bodsp.wslog.service.OrdersService;
import com.ort.bodsp.wslog.vo.OrdersParam;

@Controller
@RequestMapping("/wslog/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping
	public String index(){
		return "wslog/ordersList";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public GridPage<Orders> page(OrdersParam param) {
		GridPage<Orders> page = GridPage.valueOf(ordersService.queryForPage(param));
		return page;
	}
}
