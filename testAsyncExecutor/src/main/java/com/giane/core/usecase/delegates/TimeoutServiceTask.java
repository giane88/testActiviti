package com.giane.core.usecase.delegates;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

@Log4j2
public class TimeoutServiceTask implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    log.info("The process {} timeout executing TimeoutServiceTask {}", execution.getParentId(), execution.getProcessInstanceId());
  }
}
