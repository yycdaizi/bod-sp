package com.ort.bodsp.axis.services;

public class BizUserIPServiceProxy implements com.ort.bodsp.axis.services.BizUserIPService {
  private String _endpoint = null;
  private com.ort.bodsp.axis.services.BizUserIPService bizUserIPService = null;
  
  public BizUserIPServiceProxy() {
    _initGetUserInfoByIPProxy();
  }
  
  public BizUserIPServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initGetUserInfoByIPProxy();
  }
  
  private void _initGetUserInfoByIPProxy() {
    try {
      bizUserIPService = (new com.ort.bodsp.axis.services.BizUserIPFactoryLocator()).getService();
      if (bizUserIPService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bizUserIPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bizUserIPService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bizUserIPService != null)
      ((javax.xml.rpc.Stub)bizUserIPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ort.bodsp.axis.services.BizUserIPService getGetUserInfoByIP_PortType() {
    if (bizUserIPService == null)
      _initGetUserInfoByIPProxy();
    return bizUserIPService;
  }
  
  public com.ort.bodsp.axis.services.GetUserByIPResponse getUserInfoByIP(com.ort.bodsp.axis.services.GetUserByIPRequest getUserByIPRequest) throws java.rmi.RemoteException{
    if (bizUserIPService == null)
      _initGetUserInfoByIPProxy();
    return bizUserIPService.getUserInfoByIP(getUserByIPRequest);
  }
  
  
}