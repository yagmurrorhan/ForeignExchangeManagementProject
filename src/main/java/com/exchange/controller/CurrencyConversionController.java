package com.exchange.controller;


import com.exchange.dto.BulkConversionResult;
import com.exchange.dto.CurrencyConversionRequest;
import com.exchange.dto.CurrencyConversionResponse;
import com.exchange.model.CurrencyConversion;
import com.exchange.service.CurrencyConversionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

    private final CurrencyConversionService conversionService;

    public CurrencyConversionController(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/convert")
    public CurrencyConversionResponse convert(@RequestBody @Valid CurrencyConversionRequest request) {
        return conversionService.convert(request);
    }

    @GetMapping("/history")
    public Page<CurrencyConversion> getHistory(
            @RequestParam(required = false) String transactionId,
            @RequestParam(required = false) String date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return conversionService.getHistory(transactionId, date, pageable);
    }
    
    @PostMapping("/convert/bulk")
    public BulkConversionResult bulkConvert(@RequestParam("file") MultipartFile file) {
        return conversionService.bulkConvert(file);
    }

}
