package cl.previred.recruiting.periods.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.external-resources.ws")
public class ExternalWebServicesResuorces {

    private String incompletePeriodsUrl;

    public String getIncompletePeriodsUrl() {
        return incompletePeriodsUrl;
    }
    
    public void setIncompletePeriodsUrl(String incompletePeriodsUrl) {
        this.incompletePeriodsUrl = incompletePeriodsUrl;
    }
}
