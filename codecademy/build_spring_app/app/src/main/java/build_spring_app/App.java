/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package build_spring_app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/* 'SprintBootApplication' combines the following
    - @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
    - @ComponentScan: find all Controllers and Components which define routes
    - @Configuration: allow to register extra beans in the context or import additional configuration classes
*/
@SpringBootApplication
public class App {
    public String getClassName() {
        return this.getClass().getName();
    }

	public static void main(String[] args) {
        System.out.println(String.format("Starting Spring Boot app %s...", new App().getClassName()));

		SpringApplication.run(App.class, args);
	}

    // Prints out all of the beans loaded as part of Spring Boot app startup
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
}
