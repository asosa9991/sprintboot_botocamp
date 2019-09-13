package com.trade.autumnboot.generator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.MockGenerator;

public class FunctionChris implements MockGenerator {

	@Override
	public List<MockData> generate(LocalDate startDate, Integer numOfDays, String ticker) {
		List<MockData> mockDataList = new ArrayList<>();

		for(int i = 1; i <= numOfDays; i++) {
			MockData mockData = new MockData();
			mockData.setOnDate(startDate.plusDays(i));
			mockData.setOpenPrice(BigDecimal.valueOf(200 * i + 10.5));
			mockData.setClosePrice(BigDecimal.valueOf(190 * i + 5.5));
			mockData.setHighPrice(BigDecimal.valueOf(205 * i + 12));
			mockData.setLowPrice(BigDecimal.valueOf(185 * i + 6.5));
			mockData.setVolume(BigInteger.valueOf((long)Math.abs((1500 * Math.cos(i)))));

			mockDataList.add(mockData);
		}
		return mockDataList;
	}

	
}
