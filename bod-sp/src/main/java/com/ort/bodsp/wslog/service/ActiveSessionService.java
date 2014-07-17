package com.ort.bodsp.wslog.service;

import com.ort.bodsp.wslog.po.ActiveSession;

public interface ActiveSessionService {

	void save(ActiveSession entity);
	
	void delete(String userIP, String spId);
}
