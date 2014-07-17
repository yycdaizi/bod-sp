package com.ort.bodsp.wslog.dao;

import com.ort.bodsp.core.dao.BaseDao;
import com.ort.bodsp.wslog.po.ActiveSession;

public interface ActiveSessionDao extends BaseDao<ActiveSession>{

	void deleteSession(String userIP, String spId);

}
