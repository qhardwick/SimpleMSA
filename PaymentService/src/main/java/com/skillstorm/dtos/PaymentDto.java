package com.skillstorm.dtos;

import com.skillstorm.models.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PaymentDto {

    private int id;
    private String type;
    private BigDecimal amount;

    public PaymentDto(Payment payment) {
        this.id = payment.getId();
        this.type = payment.getType();
        this.amount = payment.getAmount();
    }

    public Payment mapToPayment() {
        Payment payment = new Payment();
        payment.setId(this.id);
        payment.setType(this.type);
        payment.setAmount(this.amount);
        return payment;
    }
}
