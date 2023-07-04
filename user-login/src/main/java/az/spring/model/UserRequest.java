package az.spring.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequest {
    Long id;
    String firstName;
    String lastName;
    Long age;
    Boolean isActive;
    String username;
    String email;
    String password;
    Boolean isAdmin;
    String nameCard;
    Long cardNumber;
    LocalDate date;
    Long cvv;
    String country;
    String address;
}
