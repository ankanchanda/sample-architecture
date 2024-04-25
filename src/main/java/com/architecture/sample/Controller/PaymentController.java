package com.architecture.sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architecture.sample.DTO.PaymentRequest;
import com.architecture.sample.DTO.PaymentResponse;
import com.architecture.sample.Service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getMethodName(@PathVariable Long id) {
        
        PaymentRequest internalRequestObj = new PaymentRequest();
        internalRequestObj.setPayementId(id);

        PaymentResponse payment = paymentService.getPaymentDetailsById(internalRequestObj);
        
        return ResponseEntity.ok(payment);
    }
    
}
