package com.shefzee.currencyconversion.repository;

import com.shefzee.currencyconversion.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, String> {
}
