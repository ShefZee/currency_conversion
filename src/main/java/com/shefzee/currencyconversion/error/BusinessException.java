package com.shefzee.currencyconversion.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private List<String> errorMessages;
    private Integer httpStatus;
}
