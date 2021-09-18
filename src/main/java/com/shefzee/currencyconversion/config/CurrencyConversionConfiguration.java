package com.shefzee.currencyconversion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(
        basePackages = {
                "com.shefzee.currencyconversion.controller",
                "com.shefzee.currencyconversion.error",
                "com.shefzee.currencyconversion.helper",
                "com.shefzee.currencyconversion.service",
                "com.shefzee.currencyconversion.service.impl",
                "com.shefzee.currencyconversion.validators"
        }
)
@EnableJpaRepositories(basePackages = {"com.shefzee.currencyconversion.repository"})
public class CurrencyConversionConfiguration {
}
