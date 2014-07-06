/**
 * GetUserByIPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ort.bodsp.axis.services;

public class GetUserByIPResponse  implements java.io.Serializable {
    private java.lang.String callerCode;

    private int result;

    private java.lang.String IPAddress;

    private java.lang.String accountNumber;

    private java.lang.Integer currentWidth;

    private java.lang.String areaID;

    private java.lang.String netType;

    public GetUserByIPResponse() {
    }

    public GetUserByIPResponse(
           java.lang.String callerCode,
           int result,
           java.lang.String IPAddress,
           java.lang.String accountNumber,
           java.lang.Integer currentWidth,
           java.lang.String areaID,
           java.lang.String netType) {
           this.callerCode = callerCode;
           this.result = result;
           this.IPAddress = IPAddress;
           this.accountNumber = accountNumber;
           this.currentWidth = currentWidth;
           this.areaID = areaID;
           this.netType = netType;
    }


    /**
     * Gets the callerCode value for this GetUserByIPResponse.
     * 
     * @return callerCode
     */
    public java.lang.String getCallerCode() {
        return callerCode;
    }


    /**
     * Sets the callerCode value for this GetUserByIPResponse.
     * 
     * @param callerCode
     */
    public void setCallerCode(java.lang.String callerCode) {
        this.callerCode = callerCode;
    }


    /**
     * Gets the result value for this GetUserByIPResponse.
     * 
     * @return result
     */
    public int getResult() {
        return result;
    }


    /**
     * Sets the result value for this GetUserByIPResponse.
     * 
     * @param result
     */
    public void setResult(int result) {
        this.result = result;
    }


    /**
     * Gets the IPAddress value for this GetUserByIPResponse.
     * 
     * @return IPAddress
     */
    public java.lang.String getIPAddress() {
        return IPAddress;
    }


    /**
     * Sets the IPAddress value for this GetUserByIPResponse.
     * 
     * @param IPAddress
     */
    public void setIPAddress(java.lang.String IPAddress) {
        this.IPAddress = IPAddress;
    }


    /**
     * Gets the accountNumber value for this GetUserByIPResponse.
     * 
     * @return accountNumber
     */
    public java.lang.String getAccountNumber() {
        return accountNumber;
    }


    /**
     * Sets the accountNumber value for this GetUserByIPResponse.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * Gets the currentWidth value for this GetUserByIPResponse.
     * 
     * @return currentWidth
     */
    public java.lang.Integer getCurrentWidth() {
        return currentWidth;
    }


    /**
     * Sets the currentWidth value for this GetUserByIPResponse.
     * 
     * @param currentWidth
     */
    public void setCurrentWidth(java.lang.Integer currentWidth) {
        this.currentWidth = currentWidth;
    }


    /**
     * Gets the areaID value for this GetUserByIPResponse.
     * 
     * @return areaID
     */
    public java.lang.String getAreaID() {
        return areaID;
    }


    /**
     * Sets the areaID value for this GetUserByIPResponse.
     * 
     * @param areaID
     */
    public void setAreaID(java.lang.String areaID) {
        this.areaID = areaID;
    }


    /**
     * Gets the netType value for this GetUserByIPResponse.
     * 
     * @return netType
     */
    public java.lang.String getNetType() {
        return netType;
    }


    /**
     * Sets the netType value for this GetUserByIPResponse.
     * 
     * @param netType
     */
    public void setNetType(java.lang.String netType) {
        this.netType = netType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserByIPResponse)) return false;
        GetUserByIPResponse other = (GetUserByIPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.callerCode==null && other.getCallerCode()==null) || 
             (this.callerCode!=null &&
              this.callerCode.equals(other.getCallerCode()))) &&
            this.result == other.getResult() &&
            ((this.IPAddress==null && other.getIPAddress()==null) || 
             (this.IPAddress!=null &&
              this.IPAddress.equals(other.getIPAddress()))) &&
            ((this.accountNumber==null && other.getAccountNumber()==null) || 
             (this.accountNumber!=null &&
              this.accountNumber.equals(other.getAccountNumber()))) &&
            ((this.currentWidth==null && other.getCurrentWidth()==null) || 
             (this.currentWidth!=null &&
              this.currentWidth.equals(other.getCurrentWidth()))) &&
            ((this.areaID==null && other.getAreaID()==null) || 
             (this.areaID!=null &&
              this.areaID.equals(other.getAreaID()))) &&
            ((this.netType==null && other.getNetType()==null) || 
             (this.netType!=null &&
              this.netType.equals(other.getNetType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCallerCode() != null) {
            _hashCode += getCallerCode().hashCode();
        }
        _hashCode += getResult();
        if (getIPAddress() != null) {
            _hashCode += getIPAddress().hashCode();
        }
        if (getAccountNumber() != null) {
            _hashCode += getAccountNumber().hashCode();
        }
        if (getCurrentWidth() != null) {
            _hashCode += getCurrentWidth().hashCode();
        }
        if (getAreaID() != null) {
            _hashCode += getAreaID().hashCode();
        }
        if (getNetType() != null) {
            _hashCode += getNetType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUserByIPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://smsservice.wlan.aaa.huawei.com/", "GetUserByIPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CallerCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IPAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentWidth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CurrentWidth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areaID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AreaID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NetType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
