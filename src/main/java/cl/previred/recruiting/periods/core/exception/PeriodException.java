package cl.previred.recruiting.periods.core.exception;

public class PeriodException extends RuntimeException {

    private PeriodExceptionType periodExceptionType;
    private String message;

    PeriodException() {
        super();
        this.periodExceptionType = PeriodExceptionType.ERROR;
    }

    PeriodException(String message) {
        super(message);
    }

    public PeriodExceptionType getPeriodExceptionType() {
        return periodExceptionType;
    }

}
