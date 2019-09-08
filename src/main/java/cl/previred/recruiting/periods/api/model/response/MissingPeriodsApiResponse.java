package cl.previred.recruiting.periods.api.model.response;

import cl.previred.recruiting.periods.api.model.ApiResponse;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Response representation for MissingPeriods service
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
public class MissingPeriodsApiResponse implements ApiResponse {

    private BigInteger id;
    private LocalDate from;
    private LocalDate to;
    private Set<LocalDate> receivedDates;
    private Set<LocalDate> missingPeriods;

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

    public Set<LocalDate> getReceivedDates() {
        if (null == receivedDates) {
            receivedDates = new LinkedHashSet<>();
        }
        return receivedDates;
    }

    public void setReceivedDates(Set<LocalDate> receivedDates) {
        this.receivedDates = receivedDates;
    }

    public Set<LocalDate> getMissingPeriods() {
        if (null == missingPeriods) {
            missingPeriods = new LinkedHashSet<>();
        }
        return missingPeriods;
    }

    public void setMissingPeriods(Set<LocalDate> missingPeriods) {
        this.missingPeriods = missingPeriods;
    }
}
