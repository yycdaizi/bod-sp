package com.ort.bodsp.ws.impl;

import java.rmi.RemoteException;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ort.bodsp.axis.services.BizCrmResponse;
import com.ort.bodsp.axis.services.BizCrmService;
import com.ort.bodsp.axis.services.BizUserIPService;
import com.ort.bodsp.axis.services.GetUserByIPRequest;
import com.ort.bodsp.axis.services.GetUserByIPResponse;
import com.ort.bodsp.axis.services.BizCrmRequest;
import com.ort.bodsp.ws.BizBod;
import com.ort.bodsp.ws.BodRequest;
import com.ort.bodsp.ws.BodResponse;

@WebService(endpointInterface = "com.ort.bodsp.ws.BizBod")
public class BizBodImpl implements BizBod {

	protected static Logger logger = LoggerFactory.getLogger(BizBodImpl.class);

	// @Autowired
	private BizCrmService bizCrmService;

	// @Autowired
	private BizUserIPService bizUserIPService;

	private String pwd;
	private String serviceCode;
	private String orgCode;
	private String callerCode;

	@Override
	public BodResponse bod(BodRequest request) {
		logger.debug("bod called;request:" + request);
		if(!this.validate(request)){
			return new BodResponse(-1001, "包格式不正确");
		}
		try {
			GetUserByIPResponse userInfo = bizUserIPService
					.getUserInfoByIP(new GetUserByIPRequest(callerCode, request
							.getUserIp()));
			
			if(!"0".equals(userInfo.getResult())){
				return new BodResponse(-1002, "未知用户IP");
			}

			BizCrmRequest rcbr = new BizCrmRequest();
			rcbr.setTransId(request.getTransId());
			rcbr.setOperationType(request.getOpertype());
			rcbr.setUserNo(userInfo.getAccountNumber());
			//rcbr.setUserNo("186123456789");
			rcbr.setUserIp(request.getUserIp());
			rcbr.setServiceCode(serviceCode);
			rcbr.setOrgCode(orgCode);
			String dataXml = rcbr.toXmlStr();

			logger.info("call webservice bizcrm bod,pwd:" + pwd + "dataXml:"
					+ dataXml);
			String result = bizCrmService.runCrmBiz(pwd, dataXml);
			logger.info(result);
			BizCrmResponse response = BizCrmResponse.parse(result);
			if("0".equals(response.getResult())){
				return new BodResponse(0);
			}else{
				return new BodResponse(-1, "操作失败");
			}
		} catch (RemoteException e) {
			logger.error("call webservice failed", e);
			return new BodResponse(-1, e.getMessage());
		}

	}
	
	private boolean validate(BodRequest request){
		if(StringUtils.isBlank(request.getTransId())){
			return false;
		}
		if(StringUtils.isBlank(request.getOpertype())){
			return false;
		}
		if(StringUtils.isBlank(request.getUserIp())){
			return false;
		}
		if(StringUtils.isBlank(request.getSpCode())){
			return false;
		}
		if(StringUtils.isBlank(request.getTimestamp())){
			return false;
		}
		if(StringUtils.isBlank(request.getSign())){
			return false;
		}
		//验证sign
		if(!StringUtils.equals(request.getSign(),request.calSign())){
			return false;
		}
		return true;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCallerCode() {
		return callerCode;
	}

	public void setCallerCode(String callerCode) {
		this.callerCode = callerCode;
	}

}
