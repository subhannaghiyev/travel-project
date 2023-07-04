package az.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCardModel {
    String email;
    Long cardNumber;
    Date date;
    Long cvv;
}
