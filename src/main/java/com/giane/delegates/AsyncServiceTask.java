package com.giane.delegates;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

@Log4j2
public class AsyncServiceTask implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    log.info("Sleeping for 3 second");
    Thread.sleep(3000);
    log.warn("AsyncCompleted");
  }
}
