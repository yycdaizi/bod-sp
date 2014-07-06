package com.ort.bodsp.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.ort.bodsp.util.MD5Utils;

@XmlAccessorType(XmlAccessType.FIELD)
public class BodRequest {

	// 交易id,由应用生成的唯一流水号
	private String transId;

	// Start--开始提速/Stop-终止提速
	private String opertype;

	private String userIp;

	private String spCode;

	private String appName;

	private String timestamp;

	private String sign;

	public BodRequest() {
		super();
	}
	
	public BodRequest(String transId, String opertype, String userIp,
			String spCode) {
		super();
		this.transId = transId;
		this.opertype = opertype;
		this.userIp = userIp;
		this.spCode = spCode;
	}


	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String calSign(){
		try {
			return MD5Utils.createMD5(transId+userIp+spCode+timestamp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public String toString() {
		return "BodRequest [transId=" + transId + ", opertype=" + opertype
				+ ", userIp=" + userIp + ", spCode=" + spCode + ", appName="
				+ appName + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}
}
