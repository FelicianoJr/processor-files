package com.dbc.analise.file.exception;

public class ReportException extends RuntimeException {

	private static final long serialVersionUID = 6646792599689236466L;
	
	public ReportException() {
		super("report create failed");
	}

}
