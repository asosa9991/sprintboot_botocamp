package com.trade.autumnboot.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class MockDataRequest {

	@NotNull(message = "Please provide a valid startDate with pattern = yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@NotNull(message = "Please provide a valid numOfDays")
	@Min(value = 1)
	private Integer numOfDays;
	@NotEmpty(message = "Please provide a ticker")
	private String ticker;
	@NotEmpty(message = "Please provide a generatorType")
	private String generatorType;
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public Integer getNumOfDays() {
		return numOfDays;
	}
	public String getTicker() {
		return ticker;
	}
	public String getGeneratorType() {
		return generatorType;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public void setGeneratorType(String generatorType) {
		this.generatorType = generatorType;
	}
	
	
	
	
}
