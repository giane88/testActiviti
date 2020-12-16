package com.giane;

import com.giane.configuration.WorkflowConfiguration;
import com.giane.entrypoints.worflow.WorkflowEntryPoints;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TestWorkFlowMain {

  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(TestWorkFlowMain.class);
  private static WorkflowConfiguration workflowConfiguration = new WorkflowConfiguration("test.bpmn");
  private static WorkflowEntryPoints workflowEntryPoints = new WorkflowEntryPoints("testProcess", workflowConfiguration.getProcessEngine());

  public static void main(String[] args) throws IOException, InterruptedException {
    workflowEntryPoints.startProcess();
    Thread.sleep(10000);
    workflowEntryPoints.complete();
    workflowEntryPoints.shutdown();
  }
}
