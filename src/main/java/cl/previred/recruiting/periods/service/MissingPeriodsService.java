package cl.previred.recruiting.periods.service;

import cl.previred.recruiting.periods.api.model.response.MissingPeriodsApiResponse;
import cl.previred.recruiting.periods.core.exception.PeriodException;
import cl.previred.recruiting.periods.core.workflow.Executor;
import cl.previred.recruiting.periods.model.IncompletePeriodsExecutorResponse;
import cl.previred.recruiting.periods.model.MissingPeriodExecutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Application main service. It get initial data from an external source, evaluates it and then it produces a new
 * response which includes dates that were not included in the entry data
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class MissingPeriodsService implements Executor<MissingPeriodExecutorRequest, MissingPeriodsApiResponse> {

    private static final Long INCREASE_MOTNH_BY = 1L;

    @Autowired
    private IncompletePeriodsService incompletePeriodsService;

    public MissingPeriodsApiResponse execute(MissingPeriodExecutorRequest requestParams) throws PeriodException {

        IncompletePeriodsExecutorResponse incompletePeriodsResponse =
                incompletePeriodsService.execute(requestParams);

        MissingPeriodsApiResponse response = new MissingPeriodsApiResponse();
        response.setId(incompletePeriodsResponse.getId());
        response.setFrom(incompletePeriodsResponse.getFrom());
        response.setTo(incompletePeriodsResponse.getTo());
        response.setReceivedDates(incompletePeriodsResponse.getPeriods());

        Set<LocalDate> missingPeriods = getMissingPeriods(
                incompletePeriodsResponse.getPeriods(),
                incompletePeriodsResponse.getFrom(),
                incompletePeriodsResponse.getTo());
        response.setMissingPeriods(missingPeriods);

        return response;
    }

    private Set<LocalDate> getMissingPeriods(Set<LocalDate> receivedPeriods, LocalDate initDate, LocalDate endDate) {
        Set<LocalDate> missingPeriods = new LinkedHashSet<>();

        if (!receivedPeriods.contains(initDate)) {
            missingPeriods.add(initDate);
        }

        while (initDate.isBefore(endDate)) {
            initDate = initDate.plusMonths(INCREASE_MOTNH_BY);
            if (!receivedPeriods.contains(initDate)) {
                missingPeriods.add(initDate);
            }
        }

        if (!receivedPeriods.contains(endDate)) {
            missingPeriods.add(endDate);
        }

        return missingPeriods;
    }

}
