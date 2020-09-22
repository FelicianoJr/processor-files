package com.dbc.analise.file.configuration;

import java.io.InputStream;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dbc.analise.file.processor.FileProcessor;

@Configuration
public class FileRouteConfiguration extends RouteBuilder {

	@Autowired
	private FileProcessor fileProcessor;

	@Override
	public void configure() throws Exception {
		from("{{route.from}}")
		.filter()
		.simple("${file:ext} == 'dat'")
		.convertBodyTo(InputStream.class)
		.process(fileProcessor)
		.to("{{route.to}}?fileName=${file:name.noext}.done.dat");
	}
}
