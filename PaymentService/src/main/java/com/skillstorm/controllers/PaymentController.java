package com.skillstorm.controllers;

import com.skillstorm.dtos.PaymentDto;
import com.skillstorm.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Test endpoint:
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello PaymentController");
    }

    // Add new Payment:
    @PostMapping
    public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentDto newPayment) {
        PaymentDto createdPayment = paymentService.addPayment(newPayment);
        return ResponseEntity.created(URI.create("/" + createdPayment.getId())).body(createdPayment);
    }

    // Find Payment by ID:
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    // Update Payment by ID:
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updateById(@PathVariable("id") int id, @RequestBody PaymentDto updatedPaymentInfo) {
        return ResponseEntity.ok(paymentService.updateById(id, updatedPaymentInfo));
    }

    // Delete Payment by ID:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
