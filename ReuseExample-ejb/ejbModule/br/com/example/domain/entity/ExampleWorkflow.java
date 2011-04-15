package br.com.example.domain.entity;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.bpm.BeginTask;
import org.jboss.seam.annotations.bpm.EndTask;
import org.jboss.seam.annotations.bpm.StartTask;
import org.jboss.seam.bpm.BusinessProcess;
import org.jboss.seam.bpm.ProcessInstance;
import org.jboss.seam.log.Log;

@Name("exampleWorkflow")
@AutoCreate
public class ExampleWorkflow {

    @Logger
    private Log log;

    private Long id;

    @In(required = false, scope = ScopeType.BUSINESS_PROCESS)
    @Out(required = false, scope = ScopeType.BUSINESS_PROCESS)
    private String initiador;

    @In(required = false, scope = ScopeType.BUSINESS_PROCESS)
    @Out(required = false, scope = ScopeType.BUSINESS_PROCESS)
    private String intention;

    @In(required = false, scope = ScopeType.BUSINESS_PROCESS)
    @Out(required = false, scope = ScopeType.BUSINESS_PROCESS)
    private Double price;

    @In(required = false, scope = ScopeType.BUSINESS_PROCESS)
    @Out(required = false, scope = ScopeType.BUSINESS_PROCESS)
    private Boolean valid;

    @In(required = false, scope = ScopeType.BUSINESS_PROCESS)
    @Out(required = false, scope = ScopeType.BUSINESS_PROCESS)
    private String status = "NOT STARTED";

    public Long startFlow() {
        if (intention == null || price == null || valid == null || initiador == null) {
            throw new IllegalStateException("Intention, Price, Valid or Initiator was not informed");
        }
        status = "STARTED";
        BusinessProcess.instance().createProcess("exampleProcess");
        id = ProcessInstance.instance().getId();
        log.info("Process started");
        return id;
    }

    public String getInitiador() {
        return initiador;
    }

    public void setInitiador(String initiador) {
        this.initiador = initiador;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getStatus() {
        return status;
    }

    @StartTask
    public void startDoSomethingTask() {
        status = "TASK STARTED";
    }
    
    @BeginTask
    public void resumeDoSomethingTask(){
        
    }

    @EndTask
    public void endDoSomethingTask() {
        status = "FINALIZED";
    }

    public Long getId() {
        return id;
    }

}
