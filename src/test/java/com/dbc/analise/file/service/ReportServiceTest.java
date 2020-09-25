package com.dbc.analise.file.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dbc.analise.file.configuration.TypeDataConfiguration;
import com.dbc.analise.file.domain.DataInfo;
import com.dbc.analise.file.domain.Report;

class ReportServiceTest {

	private ReportServiceImpl reportService;
	private TypeDataConfiguration configuration;

	@BeforeEach
	public void setup() {
		this.configuration = new TypeDataConfiguration();
		this.configuration.setCustomerId("001");
		this.configuration.setSalesManId("002");
		this.configuration.setSalesId("003");

		this.reportService = new ReportServiceImpl(configuration);
	}

	@Test
	@DisplayName("should return report object successfully")
	void shouldReturnReportObjectSuccessfully() {
		List<DataInfo> dataInfos = new ArrayList<>();
		
		final DataInfo dataInfoCustomer = DataInfo.builder()
				.id("001")
				.doc("14254521454")
				.description("50000")
				.name("Pedro")
				.build();
		
		final DataInfo dataInfoSalesMan = DataInfo.builder()
				.id("002")
				.doc("11747474747474747")
				.description("Rural")
				.name("jose")
				.build();
		
		final DataInfo dataInfo = DataInfo.builder()
				.id("003")
				.doc("10")
				.description("Joao")
				.name("[1-10-50,2-30-3.50,3-40-6.10]")
				.build();
		
		final DataInfo dataInfoPedro = DataInfo.builder()
				.id("003")
				.doc("11")
				.description("Pedro")
				.name("[1-10-100,2-30-2.50,3-40-3.10]")
				.build();
		
		dataInfos.add(dataInfoPedro);
		dataInfos.add(dataInfo);
		dataInfos.add(dataInfoSalesMan);
		dataInfos.add(dataInfoCustomer);
		
		Report report  = reportService.process(dataInfos);
		assertEquals("11", report.getExpensiveSaleId());
		assertEquals(1L, report.getTotalCustomers());
		assertEquals(1L, report.getTotalSellers());
		assertEquals("Joao", report.getName());
		
	}

}
