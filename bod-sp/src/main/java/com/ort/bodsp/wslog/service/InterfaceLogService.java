package com.ort.bodsp.wslog.service;

import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.po.InterfaceLog;
import com.ort.bodsp.wslog.vo.OrdersParam;

public interface InterfaceLogService {

	Pagination<InterfaceLog> queryForPage(OrdersParam param);

}
