package com.giane.core.usecase.delegates;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

@Log4j2
public class LoopServiceTask implements JavaDelegate {
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
