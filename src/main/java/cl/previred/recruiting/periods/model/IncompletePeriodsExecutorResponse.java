package cl.previred.recruiting.periods.model;

import cl.previred.recruiting.periods.core.model.ExecutorResponse;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class IncompletePeriodsExecutorResponse implements ExecutorResponse {
    private BigInteger id;
    private LocalDate from;
    private LocalDate to;
    private Set<LocalDate> periods;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public Set<LocalDate> getPeriods() {
        if (null == periods) {
            periods = new LinkedHashSet<>();
        }
        return periods;
    }

    public void setPeriods(Set<LocalDate> periods) {
        this.periods = periods;
    }
}
