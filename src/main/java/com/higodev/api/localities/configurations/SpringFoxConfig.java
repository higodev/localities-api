package com.higodev.api.localities.configurations;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.higodev.api.localities.resources"))
				.paths(regex("/.*"))
				.build()
				.apiInfo(metaInfo());
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Localities API", 
				"Developed by Higo Alexandre (higodev.com)", 
				"1.0.0",
				"Terms of Service", 
				new Contact(
						"Higo Alexandre", 
						"http://higodev.com/", 
						"contato@higodev.com"),
				"Apache License Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
