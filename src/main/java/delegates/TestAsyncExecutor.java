package delegates;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.impl.asyncexecutor.AsyncExecutor;
import org.activiti.engine.impl.interceptor.CommandExecutor;
import org.activiti.engine.impl.persistence.entity.JobEntity;

@Log4j2
public class TestAsyncExecutor implements AsyncExecutor {
  @Override
  public void start() {
    log.info("start");
  }

  @Override
  public void shutdown() {
log.info("stop");
  }

  @Override
  public boolean executeAsyncJob(JobEntity job) {
    return false;
  }

  @Override
  public void setCommandExecutor(CommandExecutor commandExecutor) {
log.info("set command executor");
  }

  @Override
  public CommandExecutor getCommandExecutor() {
    return null;
  }

  @Override
  public boolean isAutoActivate() {
    return false;
  }

  @Override
  public void setAutoActivate(boolean isAutoActivate) {

  }

  @Override
  public boolean isActive() {
    return false;
  }

  @Override
  public String getLockOwner() {
    return null;
  }

  @Override
  public int getTimerLockTimeInMillis() {
    return 0;
  }

  @Override
  public void setTimerLockTimeInMillis(int lockTimeInMillis) {

  }

  @Override
  public int getAsyncJobLockTimeInMillis() {
    return 0;
  }

  @Override
  public void setAsyncJobLockTimeInMillis(int lockTimeInMillis) {

  }

  @Override
  public int getDefaultTimerJobAcquireWaitTimeInMillis() {
    return 0;
  }

  @Override
  public void setDefaultTimerJobAcquireWaitTimeInMillis(int waitTimeInMillis) {

  }

  @Override
  public int getDefaultAsyncJobAcquireWaitTimeInMillis() {
    return 0;
  }

  @Override
  public void setDefaultAsyncJobAcquireWaitTimeInMillis(int waitTimeInMillis) {

  }

  @Override
  public int getDefaultQueueSizeFullWaitTimeInMillis() {
    return 0;
  }

  @Override
  public void setDefaultQueueSizeFullWaitTimeInMillis(int defaultQueueSizeFullWaitTimeInMillis) {

  }

  @Override
  public int getMaxAsyncJobsDuePerAcquisition() {
    return 0;
  }

  @Override
  public void setMaxAsyncJobsDuePerAcquisition(int maxJobs) {

  }

  @Override
  public int getMaxTimerJobsPerAcquisition() {
    return 0;
  }

  @Override
  public void setMaxTimerJobsPerAcquisition(int maxJobs) {

  }

  @Override
  public int getRetryWaitTimeInMillis() {
    return 0;
  }

  @Override
  public void setRetryWaitTimeInMillis(int retryWaitTimeInMillis) {

  }
}
