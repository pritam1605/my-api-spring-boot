package me.myengine.myRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JnitRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JnitRestApiApplication.class, args);
	}


//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/authors")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("PUT", "DELETE")
//                .allowedHeaders("header1", "header2", "header3")
//                .exposedHeaders("header1", "header2")
//                .allowCredentials(false).maxAge(3600);
//			}
//		};
//	}
}
