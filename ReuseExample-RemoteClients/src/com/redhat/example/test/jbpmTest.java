package com.redhat.example.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.Assert;

import org.jbpm.taskmgmt.exe.TaskInstance;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.example.domain.services.ProcessManagerRemoteService;

public class jbpmTest {

    private static ProcessManagerRemoteService processManagerRemote;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Context ctx = new InitialContext();
        processManagerRemote = (ProcessManagerRemoteService) ctx
                .lookup("ReuseExample-ear/ProcessManagerRemoteService/remote");
    }

    @Test
    public void testJbpmProcessFromEJB() {
        Long processId = processManagerRemote.startProcess("Testador de EJB", "Teste do Cliente EJB", 123.4);
        Assert.assertNotNull(processId);
        List<TaskInstance> tasks = processManagerRemote.getPooledTaskInstanceList("users");
        Assert.assertTrue(tasks.size() == 1);
        for (TaskInstance task : tasks) {
            String intention = (String) processManagerRemote.getVariable("intention", task.getId());
            Assert.assertEquals(intention, "Teste do Cliente EJB");
            processManagerRemote.startDoSomethingTask(task.getId());
            processManagerRemote.endDoSomethingTask(task.getId());
        }
    }
    

}
