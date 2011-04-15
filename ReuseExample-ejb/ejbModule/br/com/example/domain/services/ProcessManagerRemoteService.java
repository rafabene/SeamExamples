package br.com.example.domain.services;

import java.util.List;

import javax.ejb.Remote;

import org.jbpm.taskmgmt.exe.TaskInstance;


@Remote
public interface ProcessManagerRemoteService {
    
    public Long startProcess(String someOne, String intention, Double price);
    
    public List<TaskInstance> getPooledTaskInstanceList(String pooledActors);
    
    public void startDoSomethingTask(Long taskId);

    public void endDoSomethingTask(Long taskId);
    
    public Object getVariable(String variableName, Long taskId);

}
