package com.trade.autumnboot.generator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.generator.MockGenerator;

public class FunctionYanxin implements MockGenerator {
	@Override
	public List<MockData> generate(LocalDate startDate, Integer numOfDays, String ticker) {
		List<MockData> mockDataList = new ArrayList<>();

		Integer count = 0;
		
		LocalDate currentDate = startDate;
		double quoteDay = (double) startDate.getDayOfMonth();
		
		while (count < numOfDays) {
			MockData md = new MockData();
			md.setOnDate(currentDate);
			double openPrice = (double)(50* Math.sin(quoteDay) + 100);
			double closePrice = (double)(50* Math.cos(quoteDay) + 100);
			double highPrice = Math.max(openPrice, closePrice);
			double lowPrice = Math.min(openPrice, closePrice);
			md.setOpenPrice(BigDecimal.valueOf(openPrice));
			md.setClosePrice(BigDecimal.valueOf(closePrice));
			md.setHighPrice(BigDecimal.valueOf(highPrice + 30*Math.abs(Math.sin(quoteDay))));
			md.setLowPrice(BigDecimal.valueOf(lowPrice - 30*Math.abs(Math.cos(quoteDay))));
			md.setVolume(BigInteger.valueOf((long) (Math.pow(10, 4)*Math.abs(Math.sin(quoteDay)))));
			mockDataList.add(md);
			currentDate = currentDate.plusDays(1);
			quoteDay++;
			count++;
		}
		return mockDataList;
	}
}
