package com.dbc.analise.file.domain;


import java.math.BigDecimal;

import static com.dbc.analise.file.util.StringUtils.divideByDash;

import lombok.Getter;

@Getter
public class Items {

	private String id;
	private BigDecimal quantity;
	private BigDecimal price;

	public Items(String item) {
		String[] items = divideByDash(item);
		this.id = items[0];
		this.quantity = new BigDecimal(items[1]);
		this.price = new BigDecimal(items[2]);
	}
}
