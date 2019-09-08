package cl.previred.recruiting.periods.core.workflow;

import cl.previred.recruiting.periods.api.model.response.ErrorApiResponse;
import cl.previred.recruiting.periods.core.exception.PeriodException;
import cl.previred.recruiting.periods.core.exception.PeriodExceptionType;
import cl.previred.recruiting.periods.core.model.ExecutorRequest;
import cl.previred.recruiting.periods.core.model.ExecutorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * A class which implements the strategy pattern to handle execution of beans (services) that
 * handle API requests. The main idea behind this workflow executor is that all of the public API related services
 * (which implement the Executor interface) be handled by a standard execution process represented by this controller,
 * which warranty an uniform way to handle all exceptions, responses and common actions between services that handles
 * API logic
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiWorkflowExecutor {

    private static Logger logger = LoggerFactory.getLogger(ApiWorkflowExecutor.class);
    @Autowired
    ApplicationContext applicationContext;
    private Class<? extends Executor> executor;
    private ExecutorRequest executorRequest;

    public static ApiWorkflowExecutor getInstance() {
        return new ApiWorkflowExecutor();
    }

    public Class<? extends Executor> getExecutor() {
        return executor;
    }

    public void setExecutor(Class<? extends Executor> executor) {
        this.executor = executor;
    }

    public ExecutorRequest getExecutorRequest() {
        return executorRequest;
    }

    public void setExecutorRequest(ExecutorRequest executorRequest) {
        this.executorRequest = executorRequest;
    }

    public ResponseEntity<ExecutorResponse> execute() {
        try {
            Executor executor = applicationContext.getBean(this.executor);
            ExecutorResponse executorResponse = executor.execute(this.executorRequest);
            log(executorResponse);
            return ResponseEntity.ok(executorResponse);
        } catch (PeriodException e) {
            return handledPeriodException(e);
        } catch (Exception e) {
            return handleInternalServerErrorException(e);
        }
    }

    private ResponseEntity<ExecutorResponse> handledPeriodException(PeriodException e) {
        logWithError(e);

        ErrorApiResponse errorApiResponse = getErrorApiResponse(e);
        HttpStatus httpStatus = getErrorResponseHttpStatus(e.getPeriodExceptionType());

        return ResponseEntity.status(httpStatus).body(errorApiResponse);
    }

    private HttpStatus getErrorResponseHttpStatus(PeriodExceptionType periodExceptionType) {
        HttpStatus httpStatus;
        if (PeriodExceptionType.VALIDATION.equals(periodExceptionType)) {
            httpStatus = HttpStatus.OK;
        } else if (PeriodExceptionType.AUTHORIZATION.equals(periodExceptionType)) {
            httpStatus = HttpStatus.UNAUTHORIZED;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return httpStatus;
    }

    private ErrorApiResponse getErrorApiResponse(PeriodException e) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse();
        errorApiResponse.setMessage(e.getMessage());
        errorApiResponse.setPeriodExceptionType(e.getPeriodExceptionType());
        return errorApiResponse;
    }

    private ResponseEntity<ExecutorResponse> handleInternalServerErrorException(Exception e) {
        logWithError(e);
        ErrorApiResponse errorApiResponse = new ErrorApiResponse();
        errorApiResponse.setMessage("Unexpected error");
        errorApiResponse.setPeriodExceptionType(PeriodExceptionType.UNKNOWN);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorApiResponse);
    }

    public void log(ExecutorResponse executorResponse) {
        logger.info("API Service " + this.executor + " executed successfully");
        logger.info("Service Request", this.executorRequest);
        logger.info("Service Response", executorResponse);
    }

    public void logWithError(Exception e) {
        logger.warn("API Service " + this.executor + " executed with error", e);
        logger.warn("Service Request", this.executorRequest);
    }

}
