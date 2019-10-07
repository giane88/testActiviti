import configuration.WorkflowConfiguration;
import configuration.WorkflowManipulator;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.io.IOException;

public class TestWorkFlowMain {

  public static void main(String[] args) throws IOException {

    WorkflowConfiguration workflowConfiguration = new WorkflowConfiguration("test.bpmn");
    WorkflowManipulator workflowManipulator = new WorkflowManipulator("testProcess", workflowConfiguration.getProcessEngine());
    ProcessInstance processInstance = workflowManipulator.startProcess();
    System.in.read();
    while (processInstance.isEnded()) {
      return;
    }
  }
}
