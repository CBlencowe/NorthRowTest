package za.co.hilltop.NorthRowTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NorthRowTestApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NorthRowTestApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NorthRowTestApplication.class, args);
	}
	
}
