package com.exchange.dto;

import java.util.Map;

public class FixerApiResponse {
	private boolean success;
    private String base;
    private Map<String, Double> rates;
    
	public FixerApiResponse() {
	}

	public FixerApiResponse(boolean success, String base, Map<String, Double> rates) {
		this.success = success;
		this.base = base;
		this.rates = rates;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
    
    
    
}