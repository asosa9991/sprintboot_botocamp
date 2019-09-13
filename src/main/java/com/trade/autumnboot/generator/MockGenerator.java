package com.trade.autumnboot.generator;

import java.time.LocalDate;
import java.util.List;

import com.trade.autumnboot.dto.MockData;

public interface MockGenerator {
	public List<MockData> generate(LocalDate startDate, Integer numOfDays, String ticker);
}
