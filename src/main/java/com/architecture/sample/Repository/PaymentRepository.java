package com.architecture.sample.Repository;

import org.springframework.stereotype.Repository;

import com.architecture.sample.DTO.PaymentRequest;
import com.architecture.sample.Entity.PaymentEntity;

@Repository
public class PaymentRepository {
    
    public PaymentEntity getPaymentById(PaymentRequest request){
        PaymentEntity paymenyModel = executeQuery(request);
        return paymenyModel;
    }

    private PaymentEntity executeQuery(PaymentRequest request){
        // connect with db and fetch the data
        PaymentEntity payment = new PaymentEntity();
        payment.setId(request.getPaymentId());
        payment.setPaymentCurrency("INR");
        payment.setPaymentAmount(100.00);
        return payment;
    }

}
