package com.giane.core.usecase.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.logging.log4j.Logger;

public class AsyncServiceTask implements JavaDelegate {
  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(AsyncServiceTask.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    log.info("Sleeping for 3 second {}", execution.getProcessInstanceId());
    Thread.sleep(3000);
    log.warn("AsyncCompleted {}", execution.getProcessInstanceId());
  }
}
