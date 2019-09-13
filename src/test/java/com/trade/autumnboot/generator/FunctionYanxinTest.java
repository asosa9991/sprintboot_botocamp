package com.trade.autumnboot.generator;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.impl.FunctionYanxin;

public class FunctionYanxinTest {

	@Test
	public void testYanxinDataFunction() {
		FunctionYanxin test = new FunctionYanxin();
		List<MockData> mockDataList = test.generate(LocalDate.now(), 10, "TEST");
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(10);
		mockDataList.forEach(md -> {
			assertThat(md.getHighPrice()).isGreaterThan(md.getLowPrice());
		});
	}

}
