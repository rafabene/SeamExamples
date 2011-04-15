/**
 * PersonService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.example.domain.services;

public interface PersonService_PortType extends java.rmi.Remote {
    public java.lang.String getPersonNameById(java.lang.Long arg0) throws java.rmi.RemoteException, br.com.example.domain.services.IllegalPersonNumberException;
}
