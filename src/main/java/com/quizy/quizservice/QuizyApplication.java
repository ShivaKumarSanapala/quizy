package com.quizy.quizservice;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class QuizyApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(QuizyApplication.class, args);
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper;
	}

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping(env.getProperty("swagger.path_prefix"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.quizy.quizservice"))
				.paths(PathSelectors.any())
				.build();
	}
}
