package com.ort.bodsp.axis.services;

public class BizCrmServiceProxy implements com.ort.bodsp.axis.services.BizCrmService {
  private String _endpoint = null;
  private com.ort.bodsp.axis.services.BizCrmService bizCrmService = null;
  
  public BizCrmServiceProxy() {
    _initRtcbscrmSOAPImplProxy();
  }
  
  public BizCrmServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initRtcbscrmSOAPImplProxy();
  }
  
  private void _initRtcbscrmSOAPImplProxy() {
    try {
      bizCrmService = (new com.ort.bodsp.axis.services.BizCrmFactoryLocator()).getService();
      if (bizCrmService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bizCrmService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bizCrmService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bizCrmService != null)
      ((javax.xml.rpc.Stub)bizCrmService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ort.bodsp.axis.services.BizCrmService getRtcbscrmSOAPImpl() {
    if (bizCrmService == null)
      _initRtcbscrmSOAPImplProxy();
    return bizCrmService;
  }
  
  public java.lang.String runCrmBiz(java.lang.String pwd, java.lang.String dataXML) throws java.rmi.RemoteException{
    if (bizCrmService == null)
      _initRtcbscrmSOAPImplProxy();
    return bizCrmService.runCrmBiz(pwd, dataXML);
  }
  
  
}