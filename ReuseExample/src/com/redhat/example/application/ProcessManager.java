package com.redhat.example.application;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.security.Identity;

import br.com.example.domain.entity.ExampleWorkflow;

@Name("processManager")
@Scope(ScopeType.CONVERSATION)
public class ProcessManager implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @In
    private StatusMessages statusMessages;
    
    @In
    private ExampleWorkflow exampleWorkflow;
    
    @In
    private Identity identity;
    
    public void startExampleProcess(){
        try {
            exampleWorkflow.setInitiador(identity.getCredentials().getUsername());
            exampleWorkflow.startFlow();
            statusMessages.add(Severity.INFO, "Process started with id #{exampleWorkflow.id}");
        } catch (Exception e) {
            statusMessages.add(Severity.ERROR, "ERROR: " + e.getMessage());
        }
    }
    
    public String startDoSomeThingTask(){
        exampleWorkflow.startDoSomethingTask();
        return "taskStarted";
    }
    
    public String resumeDoSomeThingTask(){
        exampleWorkflow.resumeDoSomethingTask();
        return "taskResumed";
    }
    
    public String endDoSomeThingTask(){
        statusMessages.add(Severity.INFO, "Task #{taskInstance.name} ended!");
        exampleWorkflow.endDoSomethingTask();
        return "taskEnded";
    }

}
