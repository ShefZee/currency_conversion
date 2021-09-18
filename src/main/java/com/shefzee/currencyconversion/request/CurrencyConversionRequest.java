package com.shefzee.currencyconversion.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CurrencyConversionRequest implements Request {

    private String sourceCurrency;
    private String targetCurrency;
}

