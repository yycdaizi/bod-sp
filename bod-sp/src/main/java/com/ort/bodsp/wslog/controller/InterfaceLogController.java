package com.ort.bodsp.wslog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ort.bodsp.core.vo.GridPage;
import com.ort.bodsp.wslog.po.InterfaceLog;
import com.ort.bodsp.wslog.service.InterfaceLogService;
import com.ort.bodsp.wslog.vo.OrdersParam;

@Controller
@RequestMapping("/wslog")
public class InterfaceLogController {

	@Autowired
	private InterfaceLogService interfaceLogService;
	
	@RequestMapping
	public String index(){
		return "wslog/logList";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public GridPage<InterfaceLog> page(OrdersParam param) {
		GridPage<InterfaceLog> page = GridPage.valueOf(interfaceLogService.queryForPage(param));
		return page;
	}
}
