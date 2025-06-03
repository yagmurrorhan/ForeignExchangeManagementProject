package com.exchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exchange.dto.ExchangeRateResponse;
import com.exchange.service.ExchangeRateService;

@RestController
@RequestMapping("/api/rates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ExchangeRateResponse getRate(
            @RequestParam String from,
            @RequestParam String to) {
        return exchangeRateService.getExchangeRate(from, to);
    }
}
