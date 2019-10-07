package configuration;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;

import java.io.FileInputStream;

public class WorkflowConfiguration {
  final ProcessEngine processEngine;

  public WorkflowConfiguration(final String workFlowName) {
    processEngine = setUpProcessEngine(workFlowName);
  }

  public ProcessEngine getProcessEngine() {
    return processEngine;
  }

  private ProcessEngine setUpProcessEngine(String workFlowName) {
    ProcessEngineConfiguration cfg = null;
    cfg = new StandaloneProcessEngineConfiguration()
        .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
        .setJdbcUsername("sa")
        .setJdbcPassword("")
        .setJdbcDriver("org.h2.Driver")
        .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    final ProcessEngine processEngine = cfg.buildProcessEngine();
    RepositoryService repositoryService = processEngine.getRepositoryService();
    repositoryService.createDeployment().addClasspathResource("activiti/" + workFlowName)
        .deploy();
    return processEngine;
  }

}
