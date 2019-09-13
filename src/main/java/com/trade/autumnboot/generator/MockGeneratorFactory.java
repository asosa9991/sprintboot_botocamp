package com.trade.autumnboot.generator;

import org.springframework.stereotype.Component;

import com.trade.autumnboot.generator.impl.FunctionAndrew;
import com.trade.autumnboot.generator.impl.FunctionChris;
import com.trade.autumnboot.generator.impl.FunctionYanxin;

@Component
public class MockGeneratorFactory implements BaseMockGeneratorFactory {

	@Override
	public MockGenerator creatMockGenerator(String generatorType) {
		MockGenerator mockGenerator;
		switch (generatorType) {
		case "Function1":
			mockGenerator = new FunctionAndrew();
			break;
		case "Function2":
			mockGenerator = new FunctionYanxin();
			break;
		case "Function3":
			mockGenerator = new FunctionChris();
			break;
		default:
			mockGenerator = new FunctionChris();
		}
		return mockGenerator;
	}

}
