package br.com.example.domain.services;

public class PersonServiceProxy implements br.com.example.domain.services.PersonService_PortType {
  private String _endpoint = null;
  private br.com.example.domain.services.PersonService_PortType personService_PortType = null;
  
  public PersonServiceProxy() {
    _initPersonServiceProxy();
  }
  
  public PersonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceProxy();
  }
  
  private void _initPersonServiceProxy() {
    try {
      personService_PortType = (new br.com.example.domain.services.PersonService_ServiceLocator()).getPersonServicePort();
      if (personService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personService_PortType != null)
      ((javax.xml.rpc.Stub)personService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.example.domain.services.PersonService_PortType getPersonService_PortType() {
    if (personService_PortType == null)
      _initPersonServiceProxy();
    return personService_PortType;
  }
  
  public java.lang.String getPersonNameById(java.lang.Long arg0) throws java.rmi.RemoteException, br.com.example.domain.services.IllegalPersonNumberException{
    if (personService_PortType == null)
      _initPersonServiceProxy();
    return personService_PortType.getPersonNameById(arg0);
  }
  
  
}