package me.myengine.myRestAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

  @Bean
  public Docket swaggerSpringMvcPlugin() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
//      .apis(RequestHandlerSelectors.any())                                                      // include every spring rest controller that you have created
      .apis(RequestHandlerSelectors.basePackage("me.myengine.myRestAPI"))
//      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))    // exclude this package
      .paths(PathSelectors.any())
      .build();

//    https://stackoverflow.com/questions/40263595/how-to-hide-repository-controller-from-swagger-ui
  }
}