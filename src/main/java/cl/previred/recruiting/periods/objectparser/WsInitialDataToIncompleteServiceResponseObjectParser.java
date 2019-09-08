package cl.previred.recruiting.periods.objectparser;

import cl.previred.recruiting.periods.model.IncompletePeriodsExecutorResponse;
import cl.previred.recruiting.periods.util.ObjectParser;
import cl.previred.recruiting.periods.ws.initialdata.model.PeriodsInitialDataResponse;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class WsInitialDataToIncompleteServiceResponseObjectParser
        implements ObjectParser<PeriodsInitialDataResponse, IncompletePeriodsExecutorResponse> {

    public static WsInitialDataToIncompleteServiceResponseObjectParser getInstance() {
        return new WsInitialDataToIncompleteServiceResponseObjectParser();
    }

    @Override
    public IncompletePeriodsExecutorResponse parse(PeriodsInitialDataResponse source) {
        IncompletePeriodsExecutorResponse parsedData = new IncompletePeriodsExecutorResponse();
        parsedData.setId(source.getId());
        parsedData.setFrom(source.getFechaCreacion());
        parsedData.setTo(source.getFechaFin());

        Set<LocalDate> dates = new LinkedHashSet<>();
        dates.addAll(source.getFechas());
        parsedData.setPeriods(dates);

        return parsedData;
    }
}
