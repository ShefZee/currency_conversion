package com.shefzee.currencyconversion.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CurrencyConversionConfiguration.class,
        })
public @interface ConversionConfiguration {
}
