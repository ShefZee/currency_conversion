package com.shefzee.currencyconversion.service.impl;


import com.shefzee.currencyconversion.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {

    private final RestTemplate restTemplate;

    @Value("${car.master.service-url}")
    private String applicationUrl;


}
