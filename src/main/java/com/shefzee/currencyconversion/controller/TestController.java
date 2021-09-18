package com.shefzee.currencyconversion.controller;

import com.shefzee.carbookingservice.booking.constants.ApiConstants;
import com.shefzee.carbookingservice.booking.constants.QueueEventTypeEnum;
import com.shefzee.carbookingservice.booking.queue.QueueMessage;
import com.shefzee.carbookingservice.booking.queue.QueueMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_ROOT + "/test")
@AllArgsConstructor
public class TestController {

    private QueueMessageProducer queueMessageProducer;

    @PostMapping("/send")
    public ResponseEntity sendMessage(){
        QueueMessage message = QueueMessage.builder()
                .queueEventType(QueueEventTypeEnum.BOOKING)
                .id("1243")
                .message("Test")
                .build();
        queueMessageProducer.convertAndSend(message);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping("/hello")
    public ResponseEntity getMessage(){
        return ResponseEntity.ok("Hello");
    }
    //
}
