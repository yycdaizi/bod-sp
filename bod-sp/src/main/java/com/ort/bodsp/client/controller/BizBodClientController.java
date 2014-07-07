package com.ort.bodsp.client.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ort.bodsp.core.vo.AjaxResult;
import com.ort.bodsp.ws.BizBod;
import com.ort.bodsp.ws.BodRequest;
import com.ort.bodsp.ws.BodResponse;

@Controller
@RequestMapping("/client/bizBod")
public class BizBodClientController{
	
	@RequestMapping
	public String index(){
		return "client/bizBodCall";
	}
	
	@RequestMapping("/call")
	@ResponseBody
	public AjaxResult call(@RequestParam("url")String url, BodRequest request){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(BizBod.class);
		factory.setAddress(url);
		BizBod bizBod = (BizBod) factory.create();
		
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		request.setTimestamp(format.format(new Date()));
		request.setSign(request.calSign());
		
		BodResponse response = bizBod.bod(request);
		
		AjaxResult result = new AjaxResult(true);
		result.setData(response);
		return result;
	}
}
