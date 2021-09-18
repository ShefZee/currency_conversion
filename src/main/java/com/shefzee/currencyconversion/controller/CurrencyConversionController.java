package com.shefzee.currencyconversion.controller;

import com.shefzee.carbookingservice.booking.constants.ApiConstants;
import com.shefzee.carbookingservice.booking.request.CarBookingRequest;
import com.shefzee.carbookingservice.booking.response.CarBookingResponse;
import com.shefzee.carbookingservice.booking.service.CarBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.API_ROOT + "/car-booking")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyConversionController {
    private CarBookingService carBookingService;

    @PostMapping("/create")
    public ResponseEntity<CarBookingResponse> createBooking(@RequestBody CarBookingRequest request){
        return ResponseEntity.ok(carBookingService.saveBooking(request));
    }

    @PostMapping("/update")
    public ResponseEntity<CarBookingResponse> updateBooking(@RequestBody CarBookingRequest request){
        return ResponseEntity.ok(carBookingService.saveBooking(request));
    }

    @GetMapping("/getBooking/{id}")
    public ResponseEntity<CarBookingResponse> getBooking(@PathVariable("id") String id){
        return ResponseEntity.ok(carBookingService.getBooking(id));
    }
}
