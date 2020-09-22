package com.dbc.analise.file.domain;

import static com.dbc.analise.file.util.StringUtils.clearBracketAndComma;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class Sales {

	private String id;
	private String saleId;
	private String name;
	private List<Items> items;

	public Sales(DataInfo dataInfo) {
		this.id = dataInfo.getId();
		this.saleId = dataInfo.getDoc();
		this.name = dataInfo.getDescription();
		this.items = clearBracketAndComma(dataInfo).stream().map(Items::new).collect(Collectors.toList());
	}
}
