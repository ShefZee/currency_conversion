package com.shefzee.currencyconversion.service;


import com.shefzee.currencyconversion.entity.CurrencyConversion;
import com.shefzee.currencyconversion.response.ConversionResponse;

import java.util.List;

public interface ConversionService {

    ConversionResponse convert(String source,String target);

    List<CurrencyConversion> findAll();


}
