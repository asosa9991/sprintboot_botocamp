package com.acme.acmetrade.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.trade.autumnboot.domain.quotes.Summary;

public class summaryTest {
	@Test
	public void testSummary() {
		Summary test = new Summary();
		List<String> quoteList = Arrays.asList(
		"AAPL_2019-01-01_2019-01-21_Function1_1568386547552",
        "AAPL_2019-02-01_2019-01-21_Function2_1568386547552",
        "GLG_2019-03-01_2019-01-21_Function3_1568386547552",
        "AMZ_2019-04-01_2019-01-21_Function3_1568386547552",
        "FCB_2019-05-01_2019-01-21_Function3_1568386547552",
        "UAL_2019-06-01_2019-01-21_Function2_1568386547552",
        "UAL_2019-07-01_2019-01-21_1568386547552");
		test.getSummary(2, quoteList);
		assertThat(test.getCurrentNumOfFiles()).isEqualTo(2);
		assertThat(test.getTotalNumOfFiles()).isEqualTo(7);
		assertThat(test.getBreakdown()).isNotNull();
	}
}
