package baeldung.spring_demo_app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Main application entrypoint
@SpringBootApplication
public class App {

	public String getName() {
		return this.getClass().getName();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}		
	}
}
