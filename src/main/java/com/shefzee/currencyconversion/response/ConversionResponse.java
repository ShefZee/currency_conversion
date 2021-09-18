package com.shefzee.currencyconversion.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversionResponse implements Response {

    private String sourceCurrency;
    private String targetCurrency;
    private String value;
}
