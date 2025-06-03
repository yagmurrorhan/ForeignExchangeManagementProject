package com.exchange.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.exchange.dto.BulkConversionResult;
import com.exchange.dto.CurrencyConversionRequest;
import com.exchange.dto.CurrencyConversionResponse;
import com.exchange.model.CurrencyConversion;

public interface CurrencyConversionService {
	CurrencyConversionResponse convert(CurrencyConversionRequest request);
	Page<CurrencyConversion> getHistory(String transactionId, String date, Pageable pageable);
	BulkConversionResult bulkConvert(MultipartFile file);

}
