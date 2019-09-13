package com.trade.autumnboot.domain.quotes;

import java.util.ArrayList;
import java.util.List;

public class QuoteList {
	private List<String> quoteList = new ArrayList<> ();

	public List<String> getQuoteList() {
		return quoteList;
	}

	public void setQuoteList(List<String> quoteList) {
		this.quoteList = quoteList;
	}

	public Integer size() {
		// TODO Auto-generated method stub
		return quoteList.size();
	}		
	
}
