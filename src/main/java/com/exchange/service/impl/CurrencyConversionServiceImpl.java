package com.exchange.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exchange.dto.*;
import com.exchange.model.CurrencyConversion;
import com.exchange.repository.CurrencyConversionRepository;
import com.exchange.service.CurrencyConversionService;
import com.exchange.service.ExchangeRateService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final ExchangeRateService exchangeRateService;
    private final CurrencyConversionRepository repository;

    public CurrencyConversionServiceImpl(ExchangeRateService exchangeRateService,
                                         CurrencyConversionRepository repository) {
        this.exchangeRateService = exchangeRateService;
        this.repository = repository;
    }

    @Override
    public CurrencyConversionResponse convert(CurrencyConversionRequest request) {
        ExchangeRateResponse rateResponse = exchangeRateService.getExchangeRate(
                request.getSourceCurrency(), request.getTargetCurrency());

        double rate = rateResponse.getRate();
        double convertedAmount = request.getAmount() * rate;

        CurrencyConversion conversion = new CurrencyConversion();
        conversion.setOriginalAmount(request.getAmount());
        conversion.setConvertedAmount(convertedAmount);
        conversion.setRate(rate);
        conversion.setSourceCurrency(request.getSourceCurrency());
        conversion.setTargetCurrency(request.getTargetCurrency());

        repository.save(conversion);

        return new CurrencyConversionResponse(
                conversion.getId(),
                request.getAmount(),
                convertedAmount,
                request.getSourceCurrency(),
                request.getTargetCurrency(),
                rate
        );
    }
    
    @Override
    public Page<CurrencyConversion> getHistory(String transactionId, String date, Pageable pageable) {
        if (transactionId != null && !transactionId.isEmpty()) {
            return repository.findById(transactionId, pageable);
        } else if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date);
            LocalDateTime start = localDate.atStartOfDay();
            LocalDateTime end = localDate.plusDays(1).atStartOfDay();
            return repository.findByTimestampBetween(start, end, pageable);
        } else {
            throw new IllegalArgumentException("En az bir filtre (transactionId veya date) verilmelidir.");
        }
    }
    
    
    @Override
    public BulkConversionResult bulkConvert(MultipartFile file) {
        List<CurrencyConversionResponse> successList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header
                if (lineNumber == 1 && line.startsWith("amount")) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    errorList.add("Satır " + lineNumber + ": Format hatası");
                    continue;
                }

                try {
                    double amount = Double.parseDouble(parts[0]);
                    String from = parts[1].trim();
                    String to = parts[2].trim();

                    CurrencyConversionRequest request = new CurrencyConversionRequest();
                    request.setAmount(amount);
                    request.setSourceCurrency(from);
                    request.setTargetCurrency(to);

                    CurrencyConversionResponse response = convert(request);
                    successList.add(response);

                } catch (Exception e) {
                    errorList.add("Satır " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Dosya okunamadı: " + e.getMessage());
        }

        return new BulkConversionResult(successList, errorList);
    }

}


