package com.dbc.analise.file.domain;

import java.math.BigDecimal;

import java.util.List;
import java.util.Map.Entry;

import com.dbc.analise.file.configuration.TypeDataConfiguration;

import lombok.Getter;

@Getter
public class Report {

	private Long totalCustomers;
	private Long totalSellers;
	private String expensiveSaleId;
	private String name;

	public Report updateCustomers(List<DataInfo> items, TypeDataConfiguration typeConfig) {
		this.totalCustomers = items.stream().filter(e -> e.getId().equals(typeConfig.getCustomerId())).count();
		return this;
	}

	public Report updateSellers(List<DataInfo> items, TypeDataConfiguration typeConfig) {
		this.totalSellers = items.stream().filter(e -> e.getId().equals(typeConfig.getSalesManId())).count();
		return this;
	}

	public Report updateExpensiveSale(Entry<String, BigDecimal> saleMax) {
		this.expensiveSaleId = saleMax.getKey();
		return this;
	}

	public Report updateName(Sales sale) {
		this.name = sale.getName();
		return this;
	}

	@Override
	public String toString() {
		return "Total Customers: " + totalCustomers + ", Total Sellers: " + totalSellers + ", Most expensive sale id: "
				+ expensiveSaleId + ", Worst salesman name: " + name;
	}

}
