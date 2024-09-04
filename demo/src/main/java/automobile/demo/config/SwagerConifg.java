package automobile.demo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration

public class SwagerConifg {
	 
		
	
	
	 
	 @Bean
	    public GroupedOpenApi api() {
	        return GroupedOpenApi.builder()
	                .group("v1")
	                .pathsToMatch("/api/**")
	                .build();
	    }	

}