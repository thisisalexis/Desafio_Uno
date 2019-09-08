package cl.previred.recruiting.periods.core.exception;

public class ValidationException extends PeriodException {

    public ValidationException() {
        super();
        this.periodExceptionType = PeriodExceptionType.VALIDATION;
    }

}
