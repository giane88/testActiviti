package com.giane.core.usecase.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.logging.log4j.Logger;

public class TimeoutServiceTask implements JavaDelegate {
  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(TimeoutServiceTask.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    log.info("The process {} timeout executing TimeoutServiceTask {} - {}", execution.getParentId(), execution.getProcessInstanceId(), execution.getCurrentActivityName());
  }
}
