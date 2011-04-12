/**
 * PersonService_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.example.domain.services;

public interface PersonService_Service extends javax.xml.rpc.Service {
    public java.lang.String getPersonServicePortAddress();

    public br.com.example.domain.services.PersonService_PortType getPersonServicePort() throws javax.xml.rpc.ServiceException;

    public br.com.example.domain.services.PersonService_PortType getPersonServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
