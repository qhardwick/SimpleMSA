package com.skillstorm.services;

import com.skillstorm.dtos.PaymentDto;
import com.skillstorm.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Add a new payment to db:
    @Override
    public PaymentDto addPayment(PaymentDto newPayment) {
        return new PaymentDto(paymentRepository.saveAndFlush(newPayment.mapToPayment()));
    }

    // Find a payment by ID:
    @Override
    public PaymentDto findById(int id) {
        return paymentRepository.findById(id).map(PaymentDto::new)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    // Update a payment by ID:
    @Override
    public PaymentDto updateById(int id, PaymentDto updatedPaymentInfo) {
        findById(id);
        updatedPaymentInfo.setId(id);
        return new PaymentDto(paymentRepository.saveAndFlush(updatedPaymentInfo.mapToPayment()));
    }

    // Delete a payment by ID:
    @Override
    public void deleteById(int id) {
        findById(id);
        paymentRepository.deleteById(id);
    }
}
