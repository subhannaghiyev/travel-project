package az.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCardRequest {
    Long id;
    String nameCard; //5
    String email; //1
    Long cardNumber; //2
    LocalDate date; //3
    Long cvv; //4
    String country; //6
    String address;
    Boolean isActive;
}
