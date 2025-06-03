package com.exchange.dto;

public class CurrencyConversionResponse {
    private String transactionId;
    private double originalAmount;
    private double convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private double rate;
    
	public CurrencyConversionResponse() {

	}

	public CurrencyConversionResponse(String transactionId, double originalAmount, double convertedAmount,
			String sourceCurrency, String targetCurrency, double rate) {
		this.transactionId = transactionId;
		this.originalAmount = originalAmount;
		this.convertedAmount = convertedAmount;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.rate = rate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(double originalAmount) {
		this.originalAmount = originalAmount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
    
    
}

