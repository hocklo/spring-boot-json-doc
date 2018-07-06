package com.hocklo.samples.jsondoc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Value("${resource.handler}")
  private String resourceHandler;

  @Value("${resource.handler.location}")
  private String resourceHandlerLocation;

  @Value("${resource.handler.cache.period}")
  private Integer resourceHandlerCachePeriod;

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler(resourceHandler)
        .addResourceLocations(resourceHandlerLocation)
        .setCachePeriod(resourceHandlerCachePeriod);
  }
}
