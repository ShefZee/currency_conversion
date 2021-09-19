package com.shefzee.currencyconversion.validators;


import com.shefzee.currencyconversion.error.BusinessException;
import com.shefzee.currencyconversion.error.ErrorResponse;
import com.shefzee.currencyconversion.helper.ResourceBundleUtil;
import com.shefzee.currencyconversion.request.CurrencyConversionRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



;import static com.shefzee.currencyconversion.constants.ValidationMessageConstants.SOURCE_CURRENCY_MANDATORY;
import static com.shefzee.currencyconversion.constants.ValidationMessageConstants.TARGET_CURRENCY_MANDATORY;


@Component
@AllArgsConstructor
public class CurrencyConversionBusinessRules {

    private ResourceBundleUtil resourceBundleUtil;

    public void validate(CurrencyConversionRequest request){
        List<String> errorMessages = new ArrayList<>(Collections.emptyList());

        //validate each fields
        if(StringUtils.isEmpty(request.getSourceCurrency())){
            String errorMessage = resourceBundleUtil.getMessageFromResourceBundle(SOURCE_CURRENCY_MANDATORY);
            errorMessages.add(errorMessage);
        }
        if(StringUtils.isEmpty(request.getTargetCurrency())){
            String errorMessage = resourceBundleUtil.getMessageFromResourceBundle(TARGET_CURRENCY_MANDATORY);
            errorMessages.add(errorMessage);
        }

        if(!CollectionUtils.isEmpty(errorMessages)){
            throw BusinessException.builder()
                    .errorMessages(errorMessages)
                    .httpStatus(HttpStatus.BAD_REQUEST.value())
                    .build();
        }
    }
}
