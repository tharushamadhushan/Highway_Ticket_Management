package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO savePayment(PaymentDTO paymentDTO);
    boolean deletePayment(String paymentId);
    PaymentDTO getSelectedPayment(String paymentId);
    List<PaymentDTO> getAllPayment();
    boolean updatePayment(String paymentId, PaymentDTO paymentDTO);
}
