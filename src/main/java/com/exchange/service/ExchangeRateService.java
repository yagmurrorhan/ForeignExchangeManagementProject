package com.exchange.service;

import com.exchange.dto.ExchangeRateResponse;

public interface ExchangeRateService {
    ExchangeRateResponse getExchangeRate(String from, String to);
}