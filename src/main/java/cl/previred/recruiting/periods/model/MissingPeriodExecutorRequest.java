package cl.previred.recruiting.periods.model;

import cl.previred.recruiting.periods.core.model.ExecutorRequest;

import java.time.LocalDate;

public class MissingPeriodExecutorRequest implements ExecutorRequest {

    private LocalDate from;
    private LocalDate to;

    public MissingPeriodExecutorRequest() {
        super();
    }

    public MissingPeriodExecutorRequest(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "MissingPeriodExecutorRequest{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
