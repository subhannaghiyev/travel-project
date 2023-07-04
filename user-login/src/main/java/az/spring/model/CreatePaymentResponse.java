package az.spring.model;
//
//import lombok.Data;
//
//@Data
//public class CreatePaymentResponse {
//
//    public CreatePaymentResponse(String clientSecret) {
//    }
//}

public class CreatePaymentResponse{
    private String clientSecret;
    
    public CreatePaymentResponse(String clientSecret){ this.clientSecret = clientSecret;}

    public  String getClientSecret(){
        return clientSecret;
    }
    public void setClientSecret(String clientSecret){
        this.clientSecret = clientSecret;
    }


}