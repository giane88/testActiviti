package com.giane.configuration;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

public class WorkflowManipulator {
  private final Map<String, Object> nextDelegateVariables ;
  private final String wfName;
  private final ProcessEngine engine;

  public WorkflowManipulator(String wfName, ProcessEngine engine) {
    this.nextDelegateVariables = new HashMap<>();
    this.wfName = wfName;
    this.engine = engine;
  }


  public ProcessInstance startProcess() {
    if (nextDelegateVariables.size() > 0) {
      return engine.getRuntimeService().startProcessInstanceByKey(wfName, nextDelegateVariables);
    } else {
      return engine.getRuntimeService().startProcessInstanceByKey(wfName);
    }
  }
}
