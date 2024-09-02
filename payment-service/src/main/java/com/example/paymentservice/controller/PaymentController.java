package com.example.paymentservice.controller;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.service.PaymentService;
import com.example.paymentservice.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/health")
    public String healthTest() {
        return "Payment Health Test";
    }

//    @PostMapping
//    public PaymentDTO savePayment(@RequestBody VehicleDTO vehicleDTO) {
//        return vehicleService.saveVehicle(vehicleDTO);
//    }

    @PostMapping
    public PaymentDTO savePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @GetMapping
    public List<PaymentDTO> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @PatchMapping(value = "/{paymentId}")
    public boolean updatePayment(@RequestBody PaymentDTO paymentDTO) throws NotFoundException {
        return paymentService.updatePayment(paymentDTO.getPaymentId(),paymentDTO);
    }

    @DeleteMapping(value = "/{paymentId}")
    public boolean deletePayment(@PathVariable ("paymentId") String id) throws NotFoundException {
        return paymentService.deletePayment(id);
    }
}
