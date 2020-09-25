package com.dbc.analise.file.exception;

public class FileProcessorException extends RuntimeException {

	private static final long serialVersionUID = -7507448671429859351L;

	public FileProcessorException() {
		super("file processing failed");
	}
}
