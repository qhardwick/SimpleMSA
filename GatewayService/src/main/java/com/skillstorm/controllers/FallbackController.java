package com.skillstorm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache/")
public class FallbackController {

    @RequestMapping("/users/**")
    public ResponseEntity<String> cachedUsers() {
        return ResponseEntity.ok("User service temporarily unavailable.");
    }

    @RequestMapping("/payments/**")
    public ResponseEntity<String> cachedPayments() {
        return ResponseEntity.ok("Payment service temporarily unavailable.");
    }
}
