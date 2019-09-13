package com.trade.autumnboot.generator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.trade.autumnboot.dto.MockData;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class MockGeneratorFactoryTest {

	
	
	@Autowired
	MockGeneratorFactory generatorFactory;
	
	@Test
	public void testCreatMockGenerator_using_Function1() {
		MockGenerator generator = generatorFactory.creatMockGenerator("Function1");
		assertThat(generator).isNotNull();
		List<MockData> mockDataList = generator.generate(LocalDate.now(), 2, "AAPL");
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(2);
	}
	
	@Test
	public void testCreatMockGenerator_using_Function2() {
		MockGenerator generator = generatorFactory.creatMockGenerator("Function2");
		assertThat(generator).isNotNull();
		List<MockData> mockDataList = generator.generate(LocalDate.now(), 3, "AAPL");
		assertThat(mockDataList).isNotNull();
		assertThat(mockDataList.size()).isEqualTo(3);
	}

}
