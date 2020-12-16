package com.giane.core.usecase.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.logging.log4j.Logger;

public class LoopServiceTask implements JavaDelegate {
  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(LoopServiceTask.class);
  private int count = 0;


  @Override
  public void execute(DelegateExecution execution) throws Exception {
    if (count<10) {
      execution.setVariable("stop", false);
      log.info("Executing loop number {}", count);
      count++;
    } else {
      execution.setVariable("stop", true);
    }
  }
}
