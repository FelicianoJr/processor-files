package com.dbc.analise.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataInfo {

	private String id;
	private String doc;
	private String name;
	private String description;
}
