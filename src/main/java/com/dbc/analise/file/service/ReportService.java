package com.dbc.analise.file.service;

import java.util.List;

import com.dbc.analise.file.domain.DataInfo;
import com.dbc.analise.file.domain.Report;

public interface ReportService {

	Report process(List<DataInfo> dataInfos);
	
}
