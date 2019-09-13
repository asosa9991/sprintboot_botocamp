package com.trade.autumnboot.domain.quotes;

import java.util.HashMap;

public class QuoteTypes {
	private QuoteList historicalQuote = new QuoteList();
	public QuoteList getHistoricalQuote() {
		return historicalQuote;
	}
	public void setHistoricalQuote(QuoteList historicalQuote) {
		this.historicalQuote = historicalQuote;
	}

	private HashMap<String, QuoteList> mockedQuote = new HashMap<String, QuoteList>();

	public HashMap<String, QuoteList> getMockedQuote() {
		return mockedQuote;
	}
	public void setMockedQuote(HashMap<String, QuoteList> mockedQuote) {
		this.mockedQuote = mockedQuote;
	}
}
