package cl.previred.recruiting.periods.core.exception;

public class PeriodException extends Exception {

    protected PeriodExceptionType periodExceptionType;

    public PeriodException() {
        super();
        this.periodExceptionType = PeriodExceptionType.ERROR;
    }

    public PeriodException(Throwable e) {
        super(e);
        this.periodExceptionType = PeriodExceptionType.ERROR;
    }

    public PeriodException(PeriodExceptionType type, Throwable e) {
        super(e);
        this.periodExceptionType = type;
    }

    public PeriodException(String message) {
        super(message);
    }

    public PeriodExceptionType getPeriodExceptionType() {
        return periodExceptionType;
    }

}
