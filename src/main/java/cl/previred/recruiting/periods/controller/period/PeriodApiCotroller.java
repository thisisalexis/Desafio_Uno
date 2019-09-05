package cl.previred.recruiting.periods.controller.period;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/periods")
public class PeriodApiCotroller {

    @GetMapping(value = "lost-periods")
    public String getLostPeriods() {
        return "Todo";
    }

}