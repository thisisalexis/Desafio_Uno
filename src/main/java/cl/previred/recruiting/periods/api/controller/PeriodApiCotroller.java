package cl.previred.recruiting.periods.api.controller;

import cl.previred.recruiting.periods.core.model.ExecutorResponse;
import cl.previred.recruiting.periods.core.workflow.ApiWorkflowExecutor;
import cl.previred.recruiting.periods.service.MissingPeriodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController container for periods services
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/periods")
public class PeriodApiCotroller {

    @Autowired
    ApiWorkflowExecutor apiWorkflowExecutor;

    @GetMapping(value = "missing-periods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecutorResponse> getLostPeriods() {
        apiWorkflowExecutor.setExecutor(MissingPeriodsService.class);
        return apiWorkflowExecutor.execute();
    }

}