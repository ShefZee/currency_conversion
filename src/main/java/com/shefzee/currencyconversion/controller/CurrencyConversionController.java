package com.shefzee.currencyconversion.controller;


import com.shefzee.currencyconversion.constants.ApiConstants;
import com.shefzee.currencyconversion.entity.CurrencyConversion;
import com.shefzee.currencyconversion.request.CurrencyConversionRequest;
import com.shefzee.currencyconversion.response.ConversionResponse;
import com.shefzee.currencyconversion.service.ConversionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_ROOT + "/currency-conversion")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyConversionController {
    private ConversionService conversionService;

    @GetMapping("/")
    public ResponseEntity<ConversionResponse> getExchangeRate(@RequestParam(name="source") String source, @RequestParam(name="target") String target){
        return ResponseEntity.ok(conversionService.convert(source,target));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyConversion>> getAll(){
        return ResponseEntity.ok(conversionService.findAll());
    }


}
