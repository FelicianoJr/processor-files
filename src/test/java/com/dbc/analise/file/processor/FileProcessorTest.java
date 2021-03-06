package com.dbc.analise.file.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

@SpringBootTest
class FileProcessorTest {

	@Value("classpath:payload.dat")
	Resource resource;

	@Autowired
	private FileProcessor fileProcessor;

	@Test
	@DisplayName("should create report values successfully")
	void shouldCreateReportValuesSuccessfully() throws Exception {
		String expect = "Total Customers: 2, Total Sellers: 2, Most expensive sale id: 10, Worst salesman name: Paulo";

		CamelContext ctx = new DefaultCamelContext();
		Exchange exchange = new DefaultExchange(ctx);
		exchange.getIn().setBody(resource);

		fileProcessor.process(exchange);

		assertEquals(expect, exchange.getIn().getBody());
	}
	

}
