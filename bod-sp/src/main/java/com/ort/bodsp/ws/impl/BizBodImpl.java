package com.ort.bodsp.ws.impl;

import java.rmi.RemoteException;
import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ort.bodsp.axis.services.BizCrmRequest;
import com.ort.bodsp.axis.services.BizCrmResponse;
import com.ort.bodsp.axis.services.BizCrmService;
import com.ort.bodsp.axis.services.BizUserIPService;
import com.ort.bodsp.axis.services.GetUserByIPRequest;
import com.ort.bodsp.axis.services.GetUserByIPResponse;
import com.ort.bodsp.ws.BizBod;
import com.ort.bodsp.ws.BodRequest;
import com.ort.bodsp.ws.BodResponse;
import com.ort.bodsp.wslog.po.ActiveSession;
import com.ort.bodsp.wslog.po.InterfaceLog;
import com.ort.bodsp.wslog.service.ActiveSessionService;
import com.ort.bodsp.wslog.service.InterfaceLogService;

@WebService(endpointInterface = "com.ort.bodsp.ws.BizBod")
public class BizBodImpl implements BizBod {

	protected static Logger logger = LoggerFactory.getLogger(BizBodImpl.class);

	// @Autowired
	private BizCrmService bizCrmService;

	// @Autowired
	private BizUserIPService bizUserIPService;

	private InterfaceLogService interfaceLogService;

	private ActiveSessionService activeSessionService;

	private String pwd;
	private String serviceCode;
	private String orgCode;
	private String callerCode;

	@Override
	public BodResponse bod(BodRequest request) {
		logger.debug("bod called;request:" + request);

		InterfaceLog log = new InterfaceLog();
		log.setAcceptTime(new Date());
		// log.setContent(JSONUtils.toJSONString(request));
		// log.setInterfaceId(interfaceId);
		log.setOrderType(request.getOpertype());
		// originIP
		log.setSpId(request.getSpCode());
		log.setTransId(request.getTransId());
		log.setUserIP(request.getUserIp());

		BodResponse bodRet = null;
		String userNo = null;
		if (!this.validate(request)) {
			bodRet = new BodResponse(BodResponse.RESULT_BAD_REQUEST, "包格式不正确");
		} else {
			try {
				GetUserByIPResponse userInfo = bizUserIPService
						.getUserInfoByIP(new GetUserByIPRequest(callerCode,
								request.getUserIp()));

				if (userInfo.getResult() != 0) {
					bodRet = new BodResponse(BodResponse.RESULT_UNKNOW_IP,
							"未知用户IP");
				} else {
					userNo = userInfo.getAccountNumber();

					BizCrmRequest rcbr = new BizCrmRequest();
					rcbr.setTransId(request.getTransId());
					rcbr.setOperationType(request.getOpertype());
					rcbr.setUserNo(userNo);
					// rcbr.setUserNo("186123456789");
					rcbr.setUserIp(request.getUserIp());
					rcbr.setServiceCode(serviceCode);
					rcbr.setOrgCode(orgCode);
					String dataXml = rcbr.toXmlStr();

					log.setContent(dataXml);

					logger.info("call webservice bizcrm bod,pwd:" + pwd
							+ "dataXml:" + dataXml);
					String result = bizCrmService.runCrmBiz(pwd, dataXml);
					logger.info("call webservice bizcrm bod success, result:"
							+ result);
					BizCrmResponse response = BizCrmResponse.parse(result);
					if ("0".equals(response.getResult())) {
						bodRet = new BodResponse(BodResponse.RESULT_SUCCESS,
								"操作成功");
					} else {
						bodRet = new BodResponse(BodResponse.RESULT_FAIL,
								"操作失败");
					}
				}
			} catch (RemoteException e) {
				logger.error("call webservice failed", e);
				bodRet = new BodResponse(BodResponse.RESULT_FAIL,
						e.getMessage());
			}
		}
		log.setProcessTime(new Date());
		log.setOrderStatus(bodRet.getResult() + "");
		log.setReason(bodRet.getErrorDetail());
		interfaceLogService.save(log);

		if (bodRet.getResult() == BodResponse.RESULT_SUCCESS) {
			if (BodRequest.OPERTYPE_START.equals(request.getOpertype())) {
				ActiveSession activeSession = new ActiveSession();
				activeSession.setProviderId("1");
				activeSession.setSpId(request.getSpCode());
				activeSession.setStartTime(new Date());
				activeSession.setUserIP(request.getUserIp());
				activeSession.setUserNo(userNo);
				activeSessionService.save(activeSession);
			} else if (BodRequest.OPERTYPE_STOP.equals(request.getOpertype())) {
				activeSessionService.delete(request.getUserIp(),
						request.getSpCode());
			}
		}

		return bodRet;
	}

	private boolean validate(BodRequest request) {
		if (StringUtils.isBlank(request.getTransId())) {
			return false;
		}
		if (StringUtils.isBlank(request.getOpertype())) {
			return false;
		}
		if (StringUtils.isBlank(request.getUserIp())) {
			return false;
		}
		if (StringUtils.isBlank(request.getSpCode())) {
			return false;
		}
		if (StringUtils.isBlank(request.getTimestamp())) {
			return false;
		}
		if (StringUtils.isBlank(request.getSign())) {
			return false;
		}
		// 验证sign
		if (!StringUtils.equals(request.getSign(), request.calSign())) {
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

	public InterfaceLogService getInterfaceLogService() {
		return interfaceLogService;
	}

	public void setInterfaceLogService(InterfaceLogService interfaceLogService) {
		this.interfaceLogService = interfaceLogService;
	}

	public ActiveSessionService getActiveSessionService() {
		return activeSessionService;
	}

	public void setActiveSessionService(
			ActiveSessionService activeSessionService) {
		this.activeSessionService = activeSessionService;
	}

}
