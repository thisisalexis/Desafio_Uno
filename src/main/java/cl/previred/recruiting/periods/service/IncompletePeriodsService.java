package cl.previred.recruiting.periods.service;

import cl.previred.recruiting.periods.core.exception.PeriodException;
import cl.previred.recruiting.periods.core.workflow.Executor;
import cl.previred.recruiting.periods.model.IncompletePeriodsExecutorResponse;
import cl.previred.recruiting.periods.model.MissingPeriodExecutorRequest;
import cl.previred.recruiting.periods.objectparser.WsInitialDataToIncompleteServiceResponseObjectParser;
import cl.previred.recruiting.periods.ws.initialdata.PeriodsInitialDataWebService;
import cl.previred.recruiting.periods.ws.initialdata.model.PeriodsInitialDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Itt gets initial data from any external resource in a non-conventional format and converts it to a normalized representation
 * which matches internal application structure. It serves as a facade (pattern) to an external REST resource.
 *
 * @author Alexis Bravo
 * @version 0.1.0
 * @since 0.1.0
 */
@Service
public class IncompletePeriodsService implements
        Executor<MissingPeriodExecutorRequest, IncompletePeriodsExecutorResponse> {

    @Autowired
    PeriodsInitialDataWebService periodsInitialDataWebService;

    @Override
    public IncompletePeriodsExecutorResponse execute(MissingPeriodExecutorRequest executorParam) throws PeriodException {
        PeriodsInitialDataResponse webServiceResponse = periodsInitialDataWebService.getPeriodsInitialDataFromWebService();
        IncompletePeriodsExecutorResponse serviceResponse = parseData(webServiceResponse);
        return serviceResponse;
    }

    private IncompletePeriodsExecutorResponse parseData(PeriodsInitialDataResponse webServiceOriginalResponse) {
        IncompletePeriodsExecutorResponse parsedData =
                WsInitialDataToIncompleteServiceResponseObjectParser.getInstance().parse(webServiceOriginalResponse);

        return parsedData;
    }


}
