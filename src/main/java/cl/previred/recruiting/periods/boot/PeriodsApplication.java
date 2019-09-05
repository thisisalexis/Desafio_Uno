package cl.previred.recruiting.periods.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cl.previred.recruiting.periods")
public class PeriodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeriodsApplication.class, args);
	}

}