package com.ort.bodsp.wslog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.dao.InterfaceLogDao;
import com.ort.bodsp.wslog.po.InterfaceLog;
import com.ort.bodsp.wslog.service.InterfaceLogService;
import com.ort.bodsp.wslog.vo.OrdersParam;

@Transactional
@Service
public class InterfaceLogServiceImpl implements InterfaceLogService{
	
	@Autowired
	private InterfaceLogDao interfaceLogDao;

	@Override
	public Pagination<InterfaceLog> queryForPage(OrdersParam param) {
		return interfaceLogDao.queryForPage(param);
	}

}
