package com.giane.delegates;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

@Log4j2
public class SimpleServiceTask implements JavaDelegate {
  public void execute(DelegateExecution delegateExecution) throws Exception {
    log.info("Executing the simple delegate");
  }
}
