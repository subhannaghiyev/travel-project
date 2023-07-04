//package az.spring.controller;
//
//import az.spring.model.CustomerData;
//import az.spring.utils.StripeUtil;
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Customer;
//import com.stripe.model.CustomerCollection;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api")
//public class StripePaymentControllerAPI {
//    @Value("${stripe.apikey}")
//    String stripeKey;
//
//    private final StripeUtil stripeUtil;
//
//    @Autowired
//    public StripePaymentControllerAPI(StripeUtil stripeUtil) {
//        this.stripeUtil = stripeUtil;
//    }
//
//    @RequestMapping("/createCustomer")
//    public CustomerData createCustomer(@RequestBody CustomerData data) throws StripeException {
//        Stripe.apiKey = stripeKey;
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", data.getName());
//        params.put("email", data.getEmail());
//        Customer customer = Customer.create(params);
//        data.setCustomerId(customer.getId());
//        return data;
//    }
//
//    @RequestMapping("/getAllCustomer")
//    public List<CustomerData> getAllCustomer() throws StripeException {
//        Stripe.apiKey = stripeKey;
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("limit", 3);
//
//        CustomerCollection customers = Customer.list(params);
//        List<CustomerData> allCustomer = new ArrayList<>();
//        for (int i = 0; i < customers.getData().size(); i++) {
//            CustomerData customerData = new CustomerData();
//            customerData.setCustomerId(customers.getData().get(i).getId());
//            customerData.setName(customers.getData().get(i).getName());
//            customerData.setEmail(customers.getData().get(i).getEmail());
//            allCustomer.add(customerData);
//        }
//        return allCustomer;
//    }
//
//    @RequestMapping("/deleteCustomer/{id}")
//    public String deleteCustomer(@PathVariable("id") String id) throws StripeException {
//        Stripe.apiKey = stripeKey;
//
//        Customer customer = Customer.retrieve(id);
//
//        Customer deletedCustomer = customer.delete();
//        return "successfully deleted";
//    }
//
//    @RequestMapping("/getCustomer/{id}")
//    public CustomerData getCustomer(@PathVariable("id") String id) throws StripeException {
//
//        CustomerData output =stripeUtil.getCustomer(id);
//        return output;
//    }
//}
