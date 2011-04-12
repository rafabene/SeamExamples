package com.redhat.example.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

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
                .lookup("PocReaproveitamento-ear/ProcessManagerRemoteService/remote");
    }

    @Test
    public void testJbpmProcessFromEJB() {
        System.out.println(processManagerRemote.startProcess("Testador de EJB", "Teste do Cliente EJB", 123.4));
        List<TaskInstance> tasks = processManagerRemote.getPooledTaskInstanceList("users");
        assert tasks.size() == 1;
        for (TaskInstance task : tasks) {
            processManagerRemote.startDoSomethingTask(task.getId());
            processManagerRemote.endDoSomethingTask(task.getId());
        }
    }
    

}
