package com.trade.autumnboot.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.impl.FunctionChris;

public class FunctionChrisTest {

	@Test
	public void testChrisFunctionSize() {
		FunctionChris math = new FunctionChris();
		List<MockData> mockDataList = math.generate(LocalDate.now(), 10, "Aapl" );
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(10);
	}

}
