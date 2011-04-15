package br.com.example.domain.services;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.log.Log;
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import br.com.example.domain.entity.ExampleWorkflow;



/**
 *  This EJB is an Example how is possible to have RMI invocation and 
 *  also having JBoss Seam components bijection working.
 *  
 *  Seam Components are injected in this class
 *  
 *  Business Process variables are Outjected to the Process Instance
 *  
 *  
 * @author rafael
 *
 */
@Stateless(name="ProcessManagerRemoteService")
@Name("processManagerRemoteService")
public class ProcessManagerRemoteServiceBean implements ProcessManagerRemoteService {

    @Logger
    public Log log;

    @In
    private ExampleWorkflow exampleWorkflow;

    @In
    private Actor actor;

    @In
    private JbpmContext jbpmContext;

    public Long startProcess(String someOne, String intention, Double price) {
        exampleWorkflow.setInitiador(someOne);
        exampleWorkflow.setIntention(intention);
        exampleWorkflow.setPrice(price);
        exampleWorkflow.setValid(true);
        return exampleWorkflow.startFlow();

    }

   @SuppressWarnings("unchecked")
    public List<org.jbpm.taskmgmt.exe.TaskInstance> getPooledTaskInstanceList(String pooledActors) {
        actor.getGroupActorIds().add(pooledActors);
        List<String> actors =  new ArrayList<String>();
        actors.add(pooledActors);
        return jbpmContext.getGroupTaskList(actors);
    }

    public void startDoSomethingTask(Long taskId) {
        TaskInstance task = jbpmContext.getTaskInstance(taskId);
        log.info("Starting task " + task.getName() + " with id=" + task.getId());
        if (task.getStart() == null){
            task.start();
        }else{
            task.resume();
        }
    }

    public void endDoSomethingTask(Long taskId) {
        TaskInstance task = jbpmContext.getTaskInstance(taskId);
        log.info("Ending task " + task.getName() + " with id=" + task.getId());
        task.end();
    }
}
