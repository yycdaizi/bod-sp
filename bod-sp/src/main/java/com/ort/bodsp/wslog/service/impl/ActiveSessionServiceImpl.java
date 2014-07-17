package com.ort.bodsp.wslog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ort.bodsp.wslog.dao.ActiveSessionDao;
import com.ort.bodsp.wslog.po.ActiveSession;
import com.ort.bodsp.wslog.service.ActiveSessionService;

@Transactional
@Service
public class ActiveSessionServiceImpl implements ActiveSessionService{
	
	@Autowired
	private ActiveSessionDao activeSessionDao;

	@Override
	public void save(ActiveSession entity) {
		if(entity.getStartTime() == null){
			entity.setStartTime(new Date());
		}
		activeSessionDao.save(entity);
	}

	@Override
	public void delete(String userIP, String spId) {
		activeSessionDao.deleteSession(userIP, spId);
	}
}
