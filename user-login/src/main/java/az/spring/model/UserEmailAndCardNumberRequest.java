package az.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEmailAndCardNumberRequest {
    String email;
    Long cardNumber;
}
