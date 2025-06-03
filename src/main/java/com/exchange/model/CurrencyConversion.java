package com.exchange.model;


import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyConversion {

    @Id
    private String id = UUID.randomUUID().toString();
    private double originalAmount;
    private double convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private double rate;
    private LocalDateTime timestamp = LocalDateTime.now();
    

	public CurrencyConversion() {
	}

	public CurrencyConversion(String id, double originalAmount, double convertedAmount, String sourceCurrency,
			String targetCurrency, double rate, LocalDateTime timestamp) {
		this.id = id;
		this.originalAmount = originalAmount;
		this.convertedAmount = convertedAmount;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.rate = rate;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
    
}
