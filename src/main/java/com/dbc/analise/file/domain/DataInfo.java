package com.dbc.analise.file.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class DataInfo {

	private String id;
	private String doc;
	private String name;
	private String description;
}
