package com.ort.bodsp.ws;

import javax.jws.WebService;

@WebService
public interface BizBod {

	BodResponse bod(BodRequest request);
}
