package com.trade.autumnboot.generator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.MockGenerator;

public class FunctionAndrew implements MockGenerator {
	@Override
	public List<MockData> generate(LocalDate startDate, Integer numOfDays, String ticker) {
		// declare local variables
		List<MockData> mockDataList = new ArrayList<>();
		BigDecimal openPrice;
		BigInteger volume;
		
		// seed initial values
		openPrice = new BigDecimal("100");
		volume = new BigInteger("10000");

		for (int i=0; i < numOfDays; i++) {
			
			MockData x = new MockData();
			x.setOnDate(startDate.plusDays(i));
			x.setOpenPrice(openPrice.add(BigDecimal.valueOf(5 * i)));
			x.setClosePrice(openPrice.add(BigDecimal.valueOf(10 * i + 10)));
			x.setLowPrice(openPrice.add(BigDecimal.valueOf(5 * i)));
			x.setHighPrice(openPrice.add(BigDecimal.valueOf(10 * i + 10)));
			x.setVolume(volume.add(BigInteger.valueOf((long)(2500 * Math.sin(i)))));	
			
			mockDataList.add(x);
		}
		
		return mockDataList;
		
	}
	
}
