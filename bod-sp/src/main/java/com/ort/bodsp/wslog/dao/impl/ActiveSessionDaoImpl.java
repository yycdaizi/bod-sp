package com.ort.bodsp.wslog.dao.impl;

import org.springframework.stereotype.Repository;

import com.ort.bodsp.core.dao.BaseDaoImpl;
import com.ort.bodsp.wslog.dao.ActiveSessionDao;
import com.ort.bodsp.wslog.po.ActiveSession;

@Repository
public class ActiveSessionDaoImpl extends BaseDaoImpl<ActiveSession> implements
		ActiveSessionDao {

	@Override
	public void deleteSession(String userIP, String spId) {
		String hql = "delete from "+ActiveSession.class.getName()+" obj where obj.userIP=? and obj.spId=?";
		super.delete(hql, userIP, spId);
	}

}
