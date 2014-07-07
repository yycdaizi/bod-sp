package com.ort.bodsp.ws.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ort.bodsp.ws.BizBod;
import com.ort.bodsp.ws.BodRequest;
import com.ort.bodsp.ws.BodResponse;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"client-beans.xml");
		BizBod bizBod = (BizBod) ctx.getBean("bizBod");

		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		BodRequest request = new BodRequest("2014021414","Start","192.168.0.33","cmcc");
		request.setTimestamp(format.format(new Date()));
		request.setSign(request.calSign());
		
		BodResponse result= bizBod.bod(request);
		System.out.println("Response: " + result.getResult());
	}

}
