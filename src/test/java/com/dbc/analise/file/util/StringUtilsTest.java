package com.dbc.analise.file.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dbc.analise.file.domain.DataInfo;

class StringUtilsTest {

	@Test
	@DisplayName("should separate into three objects by dash")
	void shouldSeparateIntoThreeObjectsBybracketByDash() {
		
		String[] x = StringUtils.divideByDash("e-e");
		assertEquals(2, x.length);
		
	}
	
	@Test
	@DisplayName("should separate into three objects by bracket and comma")
	void shouldSeparateIntoThreeObjectsBybracketAndComma() {
		DataInfo dataInfo = DataInfo.builder()
				.id("003")
				.doc("10")
				.description("Pedro")
				.name("[1-10-100,2-30-2.50,3-40-3.10]")
				.build();
		
		List<String> x1  = StringUtils.clearBracketAndComma(dataInfo);
		assertEquals(3, x1.size());
	}
	
	@Test
	@DisplayName("should separate into three objects by ç")
	void shouldSeparateIntoThreeObjectsByC() {
		
		String[] x = StringUtils.divideByC("aaaçbbbbçccccc");
		assertEquals(3, x.length);
		
	}

}