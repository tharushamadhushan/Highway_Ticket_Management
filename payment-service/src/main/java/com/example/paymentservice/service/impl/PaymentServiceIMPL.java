package com.example.paymentservice.service.impl;

import com.example.paymentservice.dao.PaymentRepo;
import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.entity.PaymentEntity;
import com.example.paymentservice.service.PaymentService;
import com.example.paymentservice.util.Mapping;
import com.example.paymentservice.util.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceIMPL implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final Mapping mapping;

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {
        return mapping.toPaymentDTO(paymentRepo.save(mapping.toPaymentEntity(paymentDTO)));
    }

    @Override
    public boolean deletePayment(String paymentId) {
        Optional<PaymentEntity> payment = paymentRepo.findById(paymentId);
        if (payment.isPresent()) {
            paymentRepo.deleteById(paymentId);
            return true;
        }else{
            throw new NotFoundException(paymentId+" not found (:");
        }
    }

    @Override
    public PaymentDTO getSelectedPayment(String paymentId) {
        return null;
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return mapping.toPaymentDTOList(paymentRepo.findAll());
    }

    @Override
    public boolean updatePayment(String paymentId, PaymentDTO paymentDTO) {
        if (paymentId == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        Optional<PaymentEntity> optionalPayment = paymentRepo.findById(paymentId);
        if (optionalPayment.isPresent()) {
            PaymentEntity payment = optionalPayment.get();
            payment.setAmount(paymentDTO.getAmount());
            payment.setPaymentMethod(paymentDTO.getPaymentMethod());
            payment.setDate(paymentDTO.getDate());
            paymentRepo.save(payment);
            return true;
        } else {
            throw new NotFoundException(paymentId + " not found :(");
        }
    }
}
