package com.dbc.analise.file.domain;

import lombok.Getter;

@Getter
public class Customer {
	
	private String id;
	private String cnpj;
	private String name;
	private String salary;
	
	public Customer(DataInfo dataInfo) {
		this.id = dataInfo.getId();
		this.cnpj = dataInfo.getDoc();
		this.name = dataInfo.getName();
		this.salary = dataInfo.getDescription();
	}
}
