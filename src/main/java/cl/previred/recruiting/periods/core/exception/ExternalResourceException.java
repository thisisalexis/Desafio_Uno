package cl.previred.recruiting.periods.core.exception;

public class ExternalResourceException extends PeriodException {

    public ExternalResourceException() {
        super();
        this.periodExceptionType = PeriodExceptionType.EXTERNAL_RESOURCE;
    }

}
