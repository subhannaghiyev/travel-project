//package az.spring.controller;
//
//import az.spring.model.CreatePayment;
//import az.spring.model.CreatePaymentResponse;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//import com.stripe.param.PaymentIntentCreateParams;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class PaymentController {
//
//    @PostMapping("/create-payment-intent")
//    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
//            PaymentIntentCreateParams params =
//                    PaymentIntentCreateParams.builder()
//                            .setAmount(10 * 100L)
//                            .setCurrency("usd")
//                            .setAutomaticPaymentMethods(
//                                    PaymentIntentCreateParams.AutomaticPaymentMethods
//                                            .builder()
//                                            .setEnabled(true)
//                                            .build()
//                            )
//                            .build();
//
//            // Create a PaymentIntent with the order amount and currency
//            PaymentIntent paymentIntent = PaymentIntent.create(params);
//
//           return  new CreatePaymentResponse(paymentIntent.getClientSecret());
//
//
//    }
//}
