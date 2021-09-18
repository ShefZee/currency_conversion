package com.shefzee.currencyconversion.helper;

import com.shefzee.carbookingservice.booking.constants.ValidationMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ResourceBundleUtil {

    private final ResourceBundleMessageSource validationMessageSource;
    private static String EMPTY = "";


    public String getMessageFromResourceBundle(ValidationMessageConstants key){
        return validationMessageSource.getMessage(key.name(),null,EMPTY, Locale.getDefault());
    }
}
