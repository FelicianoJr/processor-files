package com.dbc.analise.file.processor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbc.analise.file.domain.DataInfo;
import com.dbc.analise.file.service.ReportService;

@Component
public class FileProcessor implements Processor {

	private static final String SEPARATOR = "ç";

	@Autowired
	private ReportService reportService;

	@Override
	public void process(Exchange exchange) throws Exception {
		List<DataInfo> dataInfos = new ArrayList<>();
		
		try (InputStream is = exchange.getIn().getBody(InputStream.class);
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] lines = line.split(SEPARATOR);
				dataInfos.add(new DataInfo(lines[0], lines[1], lines[2], lines[3]));
			}
		}
		exchange.getIn().setBody(reportService.process(dataInfos).toString());
	}
}
