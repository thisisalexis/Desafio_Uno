package cl.previred.recruiting.periods.core.workflow;

public class WorkflowExecutor {

    private Executor executor;
    private ExecutorParam executorParam;

    public WorkflowExecutor getInstance() {
        return new WorkflowExecutor();
    }

}
