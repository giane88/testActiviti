package com.giane.configuration;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.asyncexecutor.AsyncExecutor;
import org.activiti.engine.impl.asyncexecutor.DefaultAsyncJobExecutor;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

public class WorkflowConfiguration {
  private final ProcessEngine processEngine;

  public WorkflowConfiguration(final String workFlowName) {
    processEngine = setUpProcessEngine(workFlowName);
  }

  public ProcessEngine getProcessEngine() {
    return processEngine;
  }

  private ProcessEngine setUpProcessEngine(String workFlowName) {
    AsyncExecutor asyncExecutor = getExecutor();
    final ProcessEngine processEngine = getProcessEngine(asyncExecutor);
    deployWorkflow(workFlowName, processEngine);
    return processEngine;
  }

  private void deployWorkflow(String workFlowName, ProcessEngine processEngine) {
    RepositoryService repositoryService = processEngine.getRepositoryService();
    repositoryService.createDeployment().addClasspathResource("activiti/" + workFlowName)
        .deploy();
  }

  private ProcessEngine getProcessEngine(AsyncExecutor asyncExecutor) {
    ProcessEngineConfiguration cfg;
    cfg = new StandaloneInMemProcessEngineConfiguration()
        .setAsyncExecutor(asyncExecutor)
        .setAsyncExecutorEnabled(true)
        .setAsyncExecutorActivate(true);
    return cfg.buildProcessEngine();
  }

  private AsyncExecutor getExecutor() {
    DefaultAsyncJobExecutor asyncExecutor = new DefaultAsyncJobExecutor();
    asyncExecutor.setCorePoolSize(10);
    return asyncExecutor;
  }

}
