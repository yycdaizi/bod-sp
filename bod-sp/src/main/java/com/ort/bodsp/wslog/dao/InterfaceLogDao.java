package com.ort.bodsp.wslog.dao;

import com.ort.bodsp.core.dao.BaseDao;
import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.po.InterfaceLog;
import com.ort.bodsp.wslog.vo.OrdersParam;

public interface InterfaceLogDao extends BaseDao<InterfaceLog>{

	Pagination<InterfaceLog> queryForPage(OrdersParam param);

}
