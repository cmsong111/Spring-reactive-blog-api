package org.gdscdeu.blogreactiveapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Blog Reactive API", version = "1.0", description = "A simple blog API using Spring WebFlux"))
public class SwaggerConfig {
}
