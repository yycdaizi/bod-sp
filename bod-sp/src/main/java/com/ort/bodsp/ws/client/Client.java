package com.ort.bodsp.ws.client;

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

		BodRequest request = new BodRequest("0012","start","192.168.0.1","cmcc");
		
		BodResponse result= bizBod.bod(request);
		System.out.println("Response: " + result.getResult());
	}

}
