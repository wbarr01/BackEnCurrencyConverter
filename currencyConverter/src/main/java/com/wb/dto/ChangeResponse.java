package com.wb.dto;

import java.util.HashMap;
import java.util.Map;

public class ChangeResponse {

	String base;
	String date;
	Map<String, Double> rates =  new HashMap<String, Double>();
	
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	
	
}
