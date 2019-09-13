package com.trade.autumnboot.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.impl.FunctionAndrew;

public class FunctionAndrewTest {

	@Test
	public void testAndrewDataFunction() {
		FunctionAndrew test = new FunctionAndrew();
		List<MockData> mockDataList = test.generate(LocalDate.now(), 10, "TEST");
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(10);
	}

	@Test
	public void testAndrewDataFunctionPrices() {
		FunctionAndrew test = new FunctionAndrew();
		List<MockData> mockDataList = test.generate(LocalDate.now(), 200, "TEST");
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(200);
		mockDataList.forEach(x -> {
			assertThat(x.getLowPrice()).isLessThan(x.getHighPrice());
		});
	}
}