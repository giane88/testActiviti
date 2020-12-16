package com.giane.entrypoints.worflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WorkflowEntryPoints {
  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(WorkflowEntryPoints.class);
  private final Map<String, Object> nextDelegateVariables;
  private final String wfName;
  private final ProcessEngine engine;
  private ProcessInstance processInstance;

  public WorkflowEntryPoints(String wfName, ProcessEngine engine) {
    this.nextDelegateVariables = new HashMap<>();
    this.wfName = wfName;
    this.engine = engine;
  }


  public void startProcess() {
    log.info("Starting process called");
    if (nextDelegateVariables.size() > 0) {
      processInstance = engine.getRuntimeService().startProcessInstanceByKey(wfName, nextDelegateVariables);
    } else {
      processInstance = engine.getRuntimeService().startProcessInstanceByKey(wfName);
    }
  }

  public void complete() {
    log.info("Complete process called");
    Task task = engine.getTaskService()
        .createTaskQuery()
        .processInstanceId(processInstance.getProcessInstanceId())
        .active()
        .singleResult();
    engine.getTaskService().complete(task.getId());
  }

  public void shutdown() {
    log.info("Shutting down engine");
    engine.getProcessEngineConfiguration().getAsyncExecutor().shutdown();
  }

  public String getStatus() {
    log.info("Complete process called");
    Task task = engine.getTaskService()
        .createTaskQuery()
        .processInstanceId(processInstance.getProcessInstanceId())
        .active()
        .singleResult();
    return task.getName();
  }

}
