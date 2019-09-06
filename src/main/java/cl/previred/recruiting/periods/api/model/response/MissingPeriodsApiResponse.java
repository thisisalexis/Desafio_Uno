package cl.previred.recruiting.periods.api.model.response;

import cl.previred.recruiting.periods.api.model.ApiResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Response representation for MissingPeriods service
 *
 * @author Alexis Bravo
 * @version 0.1
 * @since 0.1
 */
public class MissingPeriodsApiResponse implements ApiResponse {

    private Integer id;
    private LocalDate from;
    private LocalDate to;
    private List<LocalDate> missingPeriods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<LocalDate> getMissingPeriods() {
        if (null == missingPeriods) {
            missingPeriods = new ArrayList<>();
        }
        return missingPeriods;
    }

    public void setMissingPeriods(List<LocalDate> missingPeriods) {
        this.missingPeriods = missingPeriods;
    }
}
