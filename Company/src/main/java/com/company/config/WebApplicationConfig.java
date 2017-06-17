package com.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Component
@ComponentScan(basePackages="com")
public class WebApplicationConfig extends WebMvcConfigurerAdapter{

		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/webjars/**")
	          .addResourceLocations("/webjars/");
	    }

}
