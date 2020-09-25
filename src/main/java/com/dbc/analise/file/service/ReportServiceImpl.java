package com.dbc.analise.file.service;

import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.analise.file.configuration.TypeDataConfiguration;
import com.dbc.analise.file.domain.DataInfo;
import com.dbc.analise.file.domain.Items;
import com.dbc.analise.file.domain.Report;
import com.dbc.analise.file.domain.Sales;
import com.dbc.analise.file.exception.ReportException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private TypeDataConfiguration typeConfig;
	
	@Override
	public Report process(List<DataInfo> dataInfos) {
		Report report = new Report();
		try {
			report.updateCustomers(dataInfos, typeConfig);
			report.updateSellers(dataInfos, typeConfig);

			final List<Sales> sales = convertForSales(dataInfos);
			final Map<String, BigDecimal> map = mapSales(sales);

			map.entrySet().stream().max(comparing(Map.Entry::getValue))
					.ifPresent(saleMax -> report.updateExpensiveSale(saleMax));

			map.entrySet().stream().min(comparing(Map.Entry::getValue))
					.ifPresent(salesMin -> findBySaleId(sales, salesMin).ifPresent(sale -> report.updateName(sale)));
		} catch (Exception e) {
			log.error("falhou man", e);
			throw new ReportException();
		}
		return report;
	}
	
	private Optional<Sales> findBySaleId(final List<Sales> sales, Entry<String, BigDecimal> map) {
		return sales.stream().filter(f -> map.getKey().equals(f.getSaleId())).findAny();
	}

	private List<Sales> convertForSales(List<DataInfo> dataInfos) {
		return dataInfos.stream()
				.filter(g -> g.getId().equals(typeConfig.getSalesId()))
				.map(Sales::new)
				.collect(Collectors.toList());
	}

	private Map<String, BigDecimal> mapSales(List<Sales> sales) {

		final Map<String, BigDecimal> maps = new HashMap<>();
		
		sales.forEach(sale -> maps.put(sale.getSaleId(),
				sale.getItems().stream()
				.map(this::multiply)
				.reduce(BigDecimal.ZERO, BigDecimal::add)));
		return maps;
	}

	private BigDecimal multiply(Items item) {
		return item.getQuantity().multiply(item.getPrice());
	}

}
