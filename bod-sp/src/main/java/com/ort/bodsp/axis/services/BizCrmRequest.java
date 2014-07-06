package com.ort.bodsp.axis.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class BizCrmRequest {

	private String transId;
	private String operationType;
	private String userNo;
	private String userIp;
	private String ServiceCode;
	private String orgCode;
	private String operName;

	public String toXmlStr() {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		StringBuilder sb = new StringBuilder();
		sb.append("<BodRequest>");
		sb.append("<TransId>").append(StringUtils.trimToEmpty(transId)).append("</TransId>");
		sb.append("<OperationType>").append(StringUtils.trimToEmpty(operationType)).append("</OperationType>");
		sb.append("<UserNo>").append(StringUtils.trimToEmpty(userNo)).append("</UserNo>");
		sb.append("<UserIP>").append(StringUtils.trimToEmpty(userIp)).append("</UserIP>");
		sb.append("<ServiceCode>").append(StringUtils.trimToEmpty(ServiceCode)).append("</ServiceCode>");
		sb.append("<OrgCode>").append(StringUtils.trimToEmpty(orgCode)).append("</OrgCode>");
		sb.append("<OperName>").append(StringUtils.trimToEmpty(operName)).append("</OperName>");
		sb.append("<TimeStamp>").append(format.format(new Date())).append("</TimeStamp>");
		sb.append("</BodRequest>");
		return sb.toString();
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getServiceCode() {
		return ServiceCode;
	}

	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}
}
