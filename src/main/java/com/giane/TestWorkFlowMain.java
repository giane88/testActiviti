package com.giane;

import com.giane.configuration.WorkflowConfiguration;
import com.giane.entrypoints.worflow.WorkflowEntryPoints;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class TestWorkFlowMain {

  private static WorkflowConfiguration workflowConfiguration = new WorkflowConfiguration("test.bpmn");
  private static WorkflowEntryPoints workflowEntryPoints = new WorkflowEntryPoints("testProcess", workflowConfiguration.getProcessEngine());

  public static void main(String[] args) throws IOException, InterruptedException {
    workflowEntryPoints.startProcess();
    workflowEntryPoints.complete();
    workflowEntryPoints.shutdown();
  }
}
