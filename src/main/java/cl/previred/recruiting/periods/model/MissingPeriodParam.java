package cl.previred.recruiting.periods.model;

import cl.previred.recruiting.periods.core.workflow.ExecutorParam;

import java.time.LocalDate;

public class MissingPeriodParam implements ExecutorParam {

    private LocalDate from;
    private LocalDate to;

    public MissingPeriodParam() {
        super();
    }

    public MissingPeriodParam(LocalDate from, LocalDate to) {
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
}
