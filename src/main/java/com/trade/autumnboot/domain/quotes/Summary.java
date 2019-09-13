package com.trade.autumnboot.domain.quotes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Summary {
	
	private Integer totalNumOfFiles;
	private Integer currentNumOfFiles;
	private Breakdown breakdown;
	
	public Integer getCurrentNumOfFiles() {
		return currentNumOfFiles;
	}
	public void setCurrentNumOfFiles(Integer currentNumOfFiles) {
		this.currentNumOfFiles = currentNumOfFiles;
	}
	public Integer getTotalNumOfFiles() {
		return totalNumOfFiles;
	}
	public void setTotalNumOfFiles(Integer totalNumOfFiles) {
		this.totalNumOfFiles = totalNumOfFiles;
	}
	public Breakdown getBreakdown() {
		return breakdown;
	}
	public void setBreakdown(Breakdown breakdown) {
		this.breakdown = breakdown;
	}

	private List<String> stockList = new ArrayList<>();
	private List<String> typeList = new ArrayList<>();
	private int count;

	public Summary getSummary ( Integer currentNumOfFiles, 
			List<String> quoteList) {
		this.setCurrentNumOfFiles(currentNumOfFiles);
		this.setTotalNumOfFiles(quoteList.size());
		this.splitQuoteList(quoteList);
		this.breakdown.setStocks(this.generateStocks(quoteList));
		return this;
	}
	private HashMap<String, List<String>> generateStocks(List<String> quoteList) {
		HashMap<String, List<String>> stocks = new HashMap<String, List<String>>();
		this.setCount(0);
		this.stockList.forEach(sl->{
			if (stocks.containsKey(sl)) {
				stocks.get(sl).add(quoteList.get(this.getCount()));
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(quoteList.get(this.getCount()));
				stocks.put(sl, newList);
			}
			this.setCount(this.count+1);
		});
		return stocks;
	}
	private void setSummary() {
		// TODO Auto-generated method stub
		
	}
	private void splitQuoteList(List<String> quoteList) {
		quoteList.forEach(quote->{
			String[] tempArray = quote.split("_");
			this.stockList.add(tempArray[0]);
			if(tempArray[3].contains("Function")) {
				this.typeList.add(tempArray[3].replace("Function","Mock model - "));
			} else {
				this.typeList.add("Historical");
			}
		});
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
