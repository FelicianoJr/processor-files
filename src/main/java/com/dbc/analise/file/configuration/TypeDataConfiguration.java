package com.dbc.analise.file.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "api.type-data")
public class TypeDataConfiguration {

	private String customerId;
	private String salesManId;
	private String salesId;
}
