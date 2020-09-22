package com.dbc.analise.file.util;

import java.util.Arrays;
import java.util.List;

import com.dbc.analise.file.domain.DataInfo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

	private static final String REGEX_BRACKET = "\\[|\\]";
	private static final String REGEX_COMMA = ",";
	private static final String REGEX_DASH = "-";

	public static List<String> clearBracketAndComma(DataInfo dataInfo) {
		return Arrays.asList(dataInfo.getName().replaceAll(REGEX_BRACKET, "").split(REGEX_COMMA));
	}

	public static String[] divideByDash(String value) {
		return value.split(REGEX_DASH);
	}

}
