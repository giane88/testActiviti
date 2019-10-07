import com.giane.configuration.WorkflowConfiguration;
import com.giane.configuration.WorkflowManipulator;
import lombok.extern.log4j.Log4j2;
import org.activiti.engine.runtime.ProcessInstance;

import java.io.IOException;

@Log4j2
public class TestWorkFlowMain {

  public static void main(String[] args) throws IOException {

    WorkflowConfiguration workflowConfiguration = new WorkflowConfiguration("test.bpmn");
    WorkflowManipulator workflowManipulator = new WorkflowManipulator("testProcess", workflowConfiguration.getProcessEngine());
    ProcessInstance processInstance = workflowManipulator.startProcess();
  }
}
