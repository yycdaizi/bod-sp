package com.ort.bodsp.ws.impl;

import java.rmi.RemoteException;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ort.bodsp.axis.services.BizCrmService;
import com.ort.bodsp.axis.services.BizUserIPService;
import com.ort.bodsp.axis.services.GetUserByIPRequest;
import com.ort.bodsp.ws.BizBod;
import com.ort.bodsp.ws.BodRequest;
import com.ort.bodsp.ws.BodResponse;

@WebService(endpointInterface="com.ort.bodsp.ws.BizBod")
public class BizBodImpl implements BizBod{

	protected static Logger logger = LoggerFactory.getLogger(BizBodImpl.class);
	
	//@Autowired
	private BizCrmService bizCrmService;
	
	//@Autowired
	private BizUserIPService bizUserIPService;
	
	@Override
	public BodResponse bod(BodRequest request) {
		logger.debug("bod called;request:"+request);
		try {
			bizUserIPService.getUserInfoByIP(new GetUserByIPRequest(request.getSpCode(), request.getUserIp()));
			bizCrmService.runCrmBiz("", "");
		} catch (RemoteException e) {
			logger.error("call webservice failed", e);
			return new BodResponse(-1, e.getMessage());
		}
		
		return new BodResponse(0);
	}

	public BizCrmService getBizCrmService() {
		return bizCrmService;
	}

	public void setBizCrmService(BizCrmService bizCrmService) {
		this.bizCrmService = bizCrmService;
	}

	public BizUserIPService getBizUserIPService() {
		return bizUserIPService;
	}

	public void setBizUserIPService(BizUserIPService bizUserIPService) {
		this.bizUserIPService = bizUserIPService;
	}
}
