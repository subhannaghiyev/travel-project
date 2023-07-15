package az.spring.controller;

import az.spring.entity.OffersData;
import az.spring.entity.Payment;
import az.spring.service.OffersDataService;
import az.spring.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/payments")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }
    @PostMapping("/savePayment")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody List<Payment> payment){
        paymentService.savePayment(payment);
    }

    @DeleteMapping("/deletePayment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
    }
}
