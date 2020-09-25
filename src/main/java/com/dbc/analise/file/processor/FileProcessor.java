package com.dbc.analise.file.processor;

import static com.dbc.analise.file.util.StringUtils.divideByC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbc.analise.file.domain.DataInfo;
import com.dbc.analise.file.exception.FileProcessorException;
import com.dbc.analise.file.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileProcessor implements Processor {

	@Autowired
	private ReportService reportService;

	@Override
	public void process(Exchange exchange) {
		List<DataInfo> dataInfos = new ArrayList<>();

		try (InputStream is = exchange.getIn().getBody(InputStream.class);
				BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

			String line = null;

			while ((line = br.readLine()) != null) {
				String[] lines = divideByC(line);
				dataInfos.add(new DataInfo(lines[0], lines[1], lines[2], lines[3]));
			}

		} catch (Exception e) {
			log.error("processor failed", e);
			throw new FileProcessorException();
		}

		exchange.getIn().setBody(reportService.process(dataInfos).toString());
	}
}
