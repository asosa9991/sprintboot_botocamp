package com.trade.autumnboot.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class MockData {
	
	private LocalDate onDate;
	private BigDecimal openPrice;
	private BigDecimal closePrice;
	private BigDecimal lowPrice;
	private BigDecimal highPrice;
	private BigInteger volume;
	public LocalDate getOnDate() {
		return onDate;
	}
	public void setOnDate(LocalDate onDate) {
		this.onDate = onDate;
	}
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	public BigInteger getVolume() {
		return volume;
	}
	public void setVolume(BigInteger volume) {
		this.volume = volume;
	}


}
