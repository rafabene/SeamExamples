package com.redhat.example.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import junit.framework.Assert;

import org.junit.Test;

import br.com.example.domain.services.IllegalPersonNumberException;
import br.com.example.domain.services.PersonService_ServiceLocator;

public class WebServiceTest {

    @Test
    public void testRetrievePersonNameFromWS() throws RemoteException, ServiceException{
        String name = new PersonService_ServiceLocator().getPersonServicePort().getPersonNameById(1L);
        Assert.assertEquals(name, "Person 1");
    }

    @Test
    public void testRetrievePersonNameFromWSNonExistentId() {
        try {
            String name = new PersonService_ServiceLocator().getPersonServicePort().getPersonNameById(6L);
            Assert.assertNull(name);
        } catch (IllegalPersonNumberException e) {
            Assert.assertNotNull(e);
        } catch (RemoteException e) {
            assert e==null: "must not have this exception";
        } catch (ServiceException e) {
            assert e==null: "must not have this exception";
        }
        
    }

}
