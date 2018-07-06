package com.hocklo.samples.jsondoc.config;

import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ActuatorEndpointConfig {

  private static final List<String> MEDIA_TYPES =
      Arrays.asList(MediaType.APPLICATION_JSON_UTF8_VALUE);
  //  Arrays.asList(MediaType.APPLICATION_JSON_UTF8_VALUE, ActuatorMediaType.V2_JSON);

  @Bean
  public EndpointMediaTypes endpointMediaTypes() {
    return new EndpointMediaTypes(MEDIA_TYPES, MEDIA_TYPES);
  }
}
