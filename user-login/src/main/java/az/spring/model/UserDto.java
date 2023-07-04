package az.spring.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserDto {
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
    Long cvv; //4
    String country;
    String address;
}
