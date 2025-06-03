package com.exchange.dto;

import java.util.List;

public class BulkConversionResult {
    private List<CurrencyConversionResponse> success;
    private List<String> errors;
    
	public BulkConversionResult() {
	}
	public BulkConversionResult(List<CurrencyConversionResponse> success, List<String> errors) {
		this.success = success;
		this.errors = errors;
	}
	public List<CurrencyConversionResponse> getSuccess() {
		return success;
	}
	public void setSuccess(List<CurrencyConversionResponse> success) {
		this.success = success;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
    
    
}
