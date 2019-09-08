package cl.previred.recruiting.periods.api.model.response;

import cl.previred.recruiting.periods.api.model.ApiResponse;
import cl.previred.recruiting.periods.core.exception.PeriodExceptionType;

public class ErrorApiResponse implements ApiResponse {

    private String message;
    private PeriodExceptionType periodExceptionType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PeriodExceptionType getPeriodExceptionType() {
        return periodExceptionType;
    }

    public void setPeriodExceptionType(PeriodExceptionType periodExceptionType) {
        this.periodExceptionType = periodExceptionType;
    }
}
