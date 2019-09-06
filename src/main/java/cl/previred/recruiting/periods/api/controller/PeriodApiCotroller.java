package cl.previred.recruiting.periods.api.controller;

import cl.previred.recruiting.periods.api.model.response.MissingPeriodsApiResponse;
import cl.previred.recruiting.periods.model.MissingPeriodParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * RestController container for periods services
 *
 * @author Alexis Bravo
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping(value = "/periods")
public class PeriodApiCotroller {

    @GetMapping(value = "missing-periods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLostPeriods(
            @RequestParam @DateTimeFormat LocalDate from,
            @RequestParam @DateTimeFormat LocalDate to
    ) {

        MissingPeriodParam param = new MissingPeriodParam(from, to);

        return ResponseEntity.ok("asdasd");
    }

}