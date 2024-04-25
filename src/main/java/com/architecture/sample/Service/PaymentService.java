package com.architecture.sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architecture.sample.DTO.PaymentRequest;
import com.architecture.sample.DTO.PaymentResponse;
import com.architecture.sample.Entity.PaymentEntity;
import com.architecture.sample.Repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj){

        PaymentEntity paymentModel = paymentRepository.getPaymentById(internalRequestObj);
        PaymentResponse paymentResponse = mapModelToResponseDTO(paymentModel);
        return paymentResponse;

    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity){

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(paymentEntity.getId());
        paymentResponse.setCurrency(paymentEntity.getPaymentCurrency());
        paymentResponse.setAmount(paymentEntity.getPaymentAmount());
        return paymentResponse;
    }

}
