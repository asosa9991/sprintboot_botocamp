package com.trade.autumnboot.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;

@Component
@ApiModel
public class MockDataRequest {

	@NotNull(message = "Please provide a valid startDate with pattern = yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Please provide a valid startDate with pattern = yyyy-MM-dd",required = true )
	private LocalDate startDate;
	
	@NotNull(message = "Please provide a valid numOfDays")
	@Min(value = 1)
	@ApiModelProperty(value = "Please provide a valid numOfDays", required = true )
	private Integer numOfDays;
	
	@NotEmpty(message = "Please provide a ticker")
	@ApiModelProperty(value = "Please provide a ticker", required = true, example = "AAPL" )
	private String ticker;
	
	@NotEmpty(message = "Please provide a generatorType")
	@ApiModelProperty(allowableValues = "Function1,Function2,Function3",value = "Please provide a generatorType", required = true)
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
