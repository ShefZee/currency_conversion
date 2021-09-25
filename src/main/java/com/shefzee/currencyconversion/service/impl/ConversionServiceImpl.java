package com.shefzee.currencyconversion.service.impl;


import com.shefzee.currencyconversion.entity.CurrencyConversion;
import com.shefzee.currencyconversion.repository.CurrencyConversionRepository;
import com.shefzee.currencyconversion.request.CurrencyConversionRequest;
import com.shefzee.currencyconversion.request.ExchangeRateRequest;
import com.shefzee.currencyconversion.response.ConversionResponse;
import com.shefzee.currencyconversion.response.ExchangeRateResponse;
import com.shefzee.currencyconversion.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {

    private final RestTemplate restTemplate;
    private final CurrencyConversionRepository currencyConversionRepository;

    @Value("${exchange-rate.service.url}")
    private String applicationUrl;

    @Override
    public ConversionResponse convert(String source,String target) {

       ExchangeRateRequest exchangeRateRequest = ExchangeRateRequest.builder()
                .sourceCurrency(source)
                .targetCurrency(target)
                .build();

       String uri = UriComponentsBuilder.fromHttpUrl(this.applicationUrl + "/converter").toUriString();
        System.out.println("uri = " + uri);
       HttpEntity<ExchangeRateRequest> httpEntity = new HttpEntity<>(exchangeRateRequest);
       ExchangeRateResponse exchangeRateResponse = this.restTemplate.exchange(uri, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<ExchangeRateResponse>() {
            }).getBody() ;

       ConversionResponse response = ConversionResponse.builder()
               .sourceCurrency(source)
               .targetCurrency(target)
               .build();

       if(Objects.nonNull(exchangeRateResponse)){
           response.setValue(exchangeRateResponse.getValue());
           save(exchangeRateResponse);

       }else{
          response.setValue("Not Found");
       }
       return response;
    }

    void save(ExchangeRateResponse response){

        //Get the latest exchange rate
        CurrencyConversion currencyConversion = currencyConversionRepository.findTop1BySourceCurrencyAndTargetCurrencyOrderByDateDesc(response.getSourceCurrency(),response.getTargetCurrency());
        CurrencyConversion conversion = CurrencyConversion.builder()
                .sourceCurrency(response.getSourceCurrency())
                .targetCurrency(response.getTargetCurrency())
                .value(Double.parseDouble(response.getValue()))
                .date(LocalDate.now())
                .build();
        if(Objects.nonNull(currencyConversion)){
            if(currencyConversion.getValue() != Double.parseDouble(response.getValue())){
                currencyConversionRepository.save(conversion);
            }
        }else{
            currencyConversionRepository.save(conversion);
        }
    }

    @Override
    public List<CurrencyConversion> findAll() {
        return currencyConversionRepository.findAll();
    }
}
