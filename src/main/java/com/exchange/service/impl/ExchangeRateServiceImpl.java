package com.exchange.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.exchange.dto.ExchangeRateResponse;
import com.exchange.dto.FixerApiResponse;
import com.exchange.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Value("${fixer.url}")
    private String fixerUrl;

    @Value("${fixer.accessKey}")
    private String accessKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ExchangeRateResponse getExchangeRate(String from, String to) {
        String url = fixerUrl + "?access_key=" + accessKey + "&symbols=" + from + "," + to;

        FixerApiResponse response = restTemplate.getForObject(url, FixerApiResponse.class);

        if (response == null || response.getRates() == null) {
            throw new RuntimeException("Fixer API'den veri alınamadı");
        }

        Double fromRate = response.getRates().get(from.toUpperCase());
        Double toRate = response.getRates().get(to.toUpperCase());

        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Geçersiz para birimi: " + from + " ya da " + to);
        }

        // EUR tabanlı oranlardan dönüşüm
        double rate = toRate / fromRate;

        return new ExchangeRateResponse(from.toUpperCase(), to.toUpperCase(), rate);
    }
}
