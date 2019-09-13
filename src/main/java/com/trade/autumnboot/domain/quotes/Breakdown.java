package com.trade.autumnboot.domain.quotes;

import java.util.HashMap;
import java.util.List;

public class Breakdown {
	private HashMap<String, List<String>> stocks = new HashMap<String, List<String>>();

	private QuoteTypes quoteTypes = new QuoteTypes ();

	public QuoteTypes getQuoteTypes() {
		return quoteTypes;
	}
	public void setQuoteTypes(QuoteTypes quoteTypes) {
		this.quoteTypes = quoteTypes;
	}
	public HashMap<String, List<String>> getStocks() {
		return stocks;
	}
	public void setStocks(HashMap<String, List<String>> hashMap) {
		this.stocks = hashMap;
	}
	

}
