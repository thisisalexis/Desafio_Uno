package cl.previred.recruiting.periods.ws.initialdata;

import cl.previred.recruiting.periods.core.exception.ExternalResourceException;
import cl.previred.recruiting.periods.properties.ExternalWebServicesResuorces;
import cl.previred.recruiting.periods.ws.initialdata.model.PeriodsInitialDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Access to an external rest service which returns a JSON representation of the application initial data
 *
 * @author Alexis Bravo
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class PeriodsInitialDataWebService {

    private static Logger logger = LoggerFactory.getLogger(PeriodsInitialDataWebService.class);

    @Autowired
    private ExternalWebServicesResuorces externalWebServicesResuorces;

    public PeriodsInitialDataResponse getPeriodsInitialDataFromWebService() throws ExternalResourceException {
        HttpHeaders httpHeaders = getHttpHeaders();
        HttpEntity<Object> httpEntity = getHttpEntity(httpHeaders);
        ResponseEntity<PeriodsInitialDataResponse> httpResponse = getHttpResponse(httpEntity);
        return httpResponse.getBody();
    }

    private String getServiceUrl() {
        return this.externalWebServicesResuorces.getIncompletePeriodsUrl();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    private HttpEntity<Object> getHttpEntity(HttpHeaders httpHeaders) {
        return new HttpEntity<>(null, httpHeaders);
    }

    private ResponseEntity<PeriodsInitialDataResponse> getHttpResponse(HttpEntity httpEntity) throws ExternalResourceException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<PeriodsInitialDataResponse> httpResponse =
                    restTemplate.exchange(getServiceUrl(), HttpMethod.GET, httpEntity, PeriodsInitialDataResponse.class);
            return httpResponse;
        } catch (RestClientException e) {
            logException();
            throw new ExternalResourceException();
        }
    }

    private void logException() {
        logger.warn("There wer a problem whilte trying to connect to PeriodsInitialDAtaWebService: " + getServiceUrl());
    }

}
