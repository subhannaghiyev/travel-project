package az.spring.service;

import az.spring.entity.User;
import az.spring.model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<UserRequest> getAllUsers();

    UserRequest getUserById(Long id);

    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto , Long id);

    void deleteUser(Long id);

    UserDto isValid(String username);

    UserDto isValidAdmin(String email);

    List<User> getFilteredUsers(UserCriteria userCriteria);

    void saveCard(UserCardRequest userCardRequest);

    User isValidEmailAndCardNumber(String email , Long cardNumber);


}
