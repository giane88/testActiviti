package com.giane.core.usecase.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.logging.log4j.Logger;

public class SimpleServiceTask implements JavaDelegate {
  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(SimpleServiceTask.class);

  public void execute(DelegateExecution execution) throws Exception {
    log.info("Executing the simple delegate {} - {}", execution.getProcessInstanceId(), execution.getCurrentActivityName());
  }
}
