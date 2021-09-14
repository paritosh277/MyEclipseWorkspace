package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	public static final Contact DEFAULT_CONTACT = new Contact(
//			"Paritosh", "http://www.in28minutes.com", "paritosh@gmail.com");
//	
//	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
//			"Awesome API Title", "Awesome API Description", "1.0",
//			"urn:tos", DEFAULT_CONTACT, 
//			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());
//	
//	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
//			new HashSet<String>(Arrays.asList("application/json"));
//	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(DEFAULT_API_INFO)
//				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
//				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
//	}
	
	@Bean
	public Docket api() {
//		System.out.println("Hum Yaha hAi");   //PathSelectors.ant("/api/*") //PathSelectors.regex("/.*")
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("com.example.demo.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiEndPointsInfo());
    }
	
	 private ApiInfo apiEndPointsInfo() {

	        return new ApiInfoBuilder().title("Spring Boot REST API")
	            .description("Employee Management REST API")
	            .contact(new Contact("Paritosh", "www.javaguides.net", "paritosh@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	   }

}
