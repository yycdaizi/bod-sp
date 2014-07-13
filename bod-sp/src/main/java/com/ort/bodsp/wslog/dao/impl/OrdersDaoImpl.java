package com.ort.bodsp.wslog.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.ort.bodsp.core.dao.BaseDaoImpl;
import com.ort.bodsp.core.vo.Pagination;
import com.ort.bodsp.wslog.dao.OrdersDao;
import com.ort.bodsp.wslog.po.Orders;
import com.ort.bodsp.wslog.vo.OrdersParam;

@Repository
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao{

	@Override
	public Pagination<Orders> queryForPage(OrdersParam param) {
		StringBuilder hql = new StringBuilder();
		hql.append("from ");
		hql.append(Orders.class.getName());
		hql.append(" obj where 1=1");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if (StringUtils.isNotBlank(param.getSort())) {
			hql.append(" order by obj." + param.getSort() + " "
					+ param.getOrder());
		}
		return this.queryForPage(hql.toString(), param.getPage(),
				param.getRows(), paramMap);
	}

}
