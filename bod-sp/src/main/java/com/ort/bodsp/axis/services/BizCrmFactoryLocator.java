/**
 * RtcbscrmSOAPImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ort.bodsp.axis.services;

public class BizCrmFactoryLocator extends org.apache.axis.client.Service implements com.ort.bodsp.axis.services.BizCrmFactory {

	private static final long serialVersionUID = -2875166177677290779L;

	public BizCrmFactoryLocator() {
    }


    public BizCrmFactoryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BizCrmFactoryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BizCrm
    private java.lang.String BizCrm_address = "http://demo1.ort.com.cn:8890/axis/services/BizCrm";

    public java.lang.String getBizCrmAddress() {
        return BizCrm_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BizCrmWSDDServiceName = "BizCrm";

    public java.lang.String getBizCrmWSDDServiceName() {
        return BizCrmWSDDServiceName;
    }

    public void setBizCrmWSDDServiceName(java.lang.String name) {
        BizCrmWSDDServiceName = name;
    }

    public com.ort.bodsp.axis.services.BizCrmService getService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BizCrm_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getService(endpoint);
    }

    public com.ort.bodsp.axis.services.BizCrmService getService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ort.bodsp.axis.services.BizCrmSoapBindingStub _stub = new com.ort.bodsp.axis.services.BizCrmSoapBindingStub(portAddress, this);
            _stub.setPortName(getBizCrmWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAddress(java.lang.String address) {
        BizCrm_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ort.bodsp.axis.services.BizCrmService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ort.bodsp.axis.services.BizCrmSoapBindingStub _stub = new com.ort.bodsp.axis.services.BizCrmSoapBindingStub(new java.net.URL(BizCrm_address), this);
                _stub.setPortName(getBizCrmWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BizCrm".equals(inputPortName)) {
            return getService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://demo1.ort.com.cn:8890/axis/services/BizCrm", "RtcbscrmSOAPImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://demo1.ort.com.cn:8890/axis/services/BizCrm", "BizCrm"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BizCrm".equals(portName)) {
            setAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
