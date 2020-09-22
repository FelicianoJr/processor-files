package com.dbc.analise.file.domain;

import lombok.Getter;

@Getter
public class SalesMan {

	private String id;
	private String cpf;
	private String name;
	private String businessArea;
	
	public SalesMan(DataInfo dataInfo) {
		this.id = dataInfo.getId();
		this.cpf = dataInfo.getDoc();
		this.name = dataInfo.getName();
		this.businessArea = dataInfo.getDescription();
	}
}
