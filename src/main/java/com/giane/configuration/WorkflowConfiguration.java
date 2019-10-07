package com.giane.configuration;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.asyncexecutor.AsyncExecutor;
import org.activiti.engine.impl.asyncexecutor.ManagedAsyncJobExecutor;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

public class WorkflowConfiguration {
  final ProcessEngine processEngine;

  public WorkflowConfiguration(final String workFlowName) {
    processEngine = setUpProcessEngine(workFlowName);
  }

  public ProcessEngine getProcessEngine() {
    return processEngine;
  }

  private ProcessEngine setUpProcessEngine(String workFlowName) {
    ProcessEngineConfiguration cfg;
    AsyncExecutor asyncExecutor = new ManagedAsyncJobExecutor();
    cfg = new StandaloneInMemProcessEngineConfiguration()
        .setAsyncExecutor(asyncExecutor)
        .setAsyncExecutorEnabled(true)
        .setAsyncExecutorActivate(true);
    final ProcessEngine processEngine = cfg.buildProcessEngine();
    RepositoryService repositoryService = processEngine.getRepositoryService();
    repositoryService.createDeployment().addClasspathResource("activiti/" + workFlowName)
        .deploy();
    return processEngine;
  }

}
