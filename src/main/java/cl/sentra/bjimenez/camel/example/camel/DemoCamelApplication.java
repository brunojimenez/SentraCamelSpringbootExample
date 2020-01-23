package cl.sentra.bjimenez.camel.example.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:/spring-camel-context.xml" })
public class DemoCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCamelApplication.class, args);
	}

}
