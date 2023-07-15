package az.spring.service;

import az.spring.entity.OffersData;
import az.spring.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayment();

    void savePayment(List<Payment> payment);

    void deletePayment(Long id);
}
