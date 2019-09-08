package cl.previred.recruiting.periods.core.workflow;

import cl.previred.recruiting.periods.core.exception.PeriodException;
import cl.previred.recruiting.periods.core.model.ExecutorRequest;
import cl.previred.recruiting.periods.core.model.ExecutorResponse;

/**
 * An executor is an interface that represents any service that executes an in/out operation in the application.
 * It helps to have a common and unique behavior to all services with one and only one function
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Executor<rq extends ExecutorRequest, rs extends ExecutorResponse> {

    rs execute(rq executorParam) throws PeriodException;

}
