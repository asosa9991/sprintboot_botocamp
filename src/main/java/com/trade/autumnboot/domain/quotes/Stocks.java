package com.trade.autumnboot.domain.quotes;

import java.util.HashMap;

public class Stocks {
	private HashMap<String, QuoteList> stocks = new HashMap<String, QuoteList>();

	public HashMap<String, QuoteList> getStocks() {
		return stocks;
	}

	public void setStocks(HashMap<String, QuoteList> stocks) {
		this.stocks = stocks;
	}

}
