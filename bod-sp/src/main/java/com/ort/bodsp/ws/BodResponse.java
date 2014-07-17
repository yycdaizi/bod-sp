package com.ort.bodsp.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodResponse")
public class BodResponse {
	public static final int RESULT_SUCCESS = 0;
	public static final int RESULT_FAIL = -1;
	public static final int RESULT_BAD_REQUEST = -1001;
	public static final int RESULT_UNKNOW_IP = -1002;

	private Integer result;
	private String errorDetail;

	public BodResponse() {
		super();
	}

	public BodResponse(Integer result) {
		super();
		this.result = result;
	}

	public BodResponse(Integer result, String errorDetail) {
		super();
		this.result = result;
		this.errorDetail = errorDetail;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

}
