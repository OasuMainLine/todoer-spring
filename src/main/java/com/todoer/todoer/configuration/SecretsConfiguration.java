package com.todoer.todoer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:secrets.properties")
public class SecretsConfiguration {
}
