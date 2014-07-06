package com.ort.bodsp.axis.services;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class BizCrmResponse {

	private String result;
	private String errorDetail;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public static BizCrmResponse parse(String xml) {
		Document doc = null;
		try {
			BizCrmResponse obj = new BizCrmResponse();
			doc = DocumentHelper.parseText(xml);
			Node resultNode = doc.selectSingleNode("/BodResponse/Result");
			if (resultNode != null) {
				obj.setResult(resultNode.getText());
			}

			Node detailNode = doc.selectSingleNode("/BodResponse/ErrorDetail");
			if (detailNode != null) {
				obj.setErrorDetail(detailNode.getText());
			}
			return obj;
		} catch (DocumentException e) {
			throw new RuntimeException("xml解析出错", e);
		}
	}
}
