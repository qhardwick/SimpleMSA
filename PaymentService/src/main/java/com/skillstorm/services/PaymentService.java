package com.skillstorm.services;

import com.skillstorm.dtos.PaymentDto;

public interface PaymentService {

    // Add a new payment to db:
    PaymentDto addPayment(PaymentDto newPayment);

    // Find a payment by ID:
    PaymentDto findById(int id);

    // Update a payment by ID:
    PaymentDto updateById(int id, PaymentDto updatedPaymentInfo);

    // Delete a payment by ID:
    void deleteById(int id);
}
