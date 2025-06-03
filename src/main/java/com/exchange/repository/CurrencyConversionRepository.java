package com.exchange.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exchange.model.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, String> {
	
	Page<CurrencyConversion> findById(String id, Pageable pageable);

    Page<CurrencyConversion> findByTimestampBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
