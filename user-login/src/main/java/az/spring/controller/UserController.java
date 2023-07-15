package az.spring.controller;

import az.spring.config.RedisTokenService;
import az.spring.entity.User;
import az.spring.exception.*;
import az.spring.mapper.UserMapper;
import az.spring.model.*;
import az.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    private final RedisTokenService redisTokenService;

    private final UserMapper userMapper;

    private String previousToken;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserRequest> getAllUsers(@ModelAttribute UserCriteria userCriteria) {
//        boolean isValidToken = redisTokenService.isValidToken(token);
//        boolean hasExpired = redisTokenService.hasTokenExpired(token);


//        System.out.println("Previous Token: " + previousToken);
//        System.out.println("Current Token: " + token);

//        if (!isValidToken && !token.equals(previousToken)) {
//            log.warn("Invalid token: " + token);
//            throw new TokenIsNotValidException("Token is not valid");
//        } else if (hasExpired) {
//            log.warn("Token has expired: " + token);
//            throw new UnAuthorizedException("Token has expired");
//        } else {
        List<User> filteredUsers = userService.getFilteredUsers(userCriteria);

        List<UserRequest> userRequestList = new ArrayList<>();
        for (User user : filteredUsers) {
            UserRequest userRequest = userMapper.mapEntityToRequest(user);
            userRequestList.add(userRequest);
        }

//            previousToken = token;

        return userRequestList;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserRequest getUserById(@PathVariable Long id) {
//        boolean validToken = redisTokenService.isValidToken(token);
//        if (!validToken && !token.equals(previousToken)) {
//            log.warn("Invalid token: " + token);
//            throw new TokenIsNotValidException("Token is not valid");
//        }
//        boolean hasExpired = redisTokenService.hasTokenExpired(token);
//        if (hasExpired) {
//            log.warn("Token has expired: " + token);
//            throw new UnAuthorizedException("Token has expired");
//        }
//
//        previousToken = token;

        return userService.getUserById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        UserDto valid = userService.isValid(userDto.getUsername());
        if (valid != null && valid.getUsername().equalsIgnoreCase(userDto.getUsername())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
//        boolean validToken = redisTokenService.isValidToken(token);
//        if (!validToken && !token.equals(previousToken)) {
//            log.warn("Invalid token: " + token);
//            throw new TokenIsNotValidException("Token is not valid");
//        }
//        boolean hasExpired = redisTokenService.hasTokenExpired(token);
//        if (hasExpired) {
//            log.warn("Token has expired: " + token);
//            throw new UnAuthorizedException("Token has expired");
//        }
//        previousToken = token;

        userService.updateUser(userDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id, @RequestHeader String token) {
        boolean validToken = redisTokenService.isValidToken(token);
        if (!validToken && !token.equals(previousToken)) {
            log.warn("Invalid token: " + token);
            throw new TokenIsNotValidException("Token is not valid");
        }
        boolean hasExpired = redisTokenService.hasTokenExpired(token);
        if (hasExpired) {
            log.warn("Token has expired: " + token);
            throw new UnAuthorizedException("Token has expired");
        }

        previousToken = token;
        userService.deleteUser(id);
    }


    //    @PostMapping("/login")
//    public ResponseEntity<UserDto> isValid(@RequestBody LoginRequest loginRequest) {
//        UserDto valid = userService.isValid(loginRequest.getUsername());
//
//        if (valid != null && valid.getUsername().equalsIgnoreCase(loginRequest.getUsername())) {
//            if (loginRequest.getPassword().equals(valid.getPassword())) {
//                String token = redisTokenService.generateToken(valid.getId());
//                redisTokenService.saveToken(valid.getId(), token);
//                HttpHeaders headers = new HttpHeaders();
//                headers.add("Authorization", token);
//                System.out.println(token);
//                return ResponseEntity.ok().headers(headers).body(valid);
//            } else {
//                throw new InvalidPasswordException("Invalid password");
//            }
//        } else {
//            throw new UserNotFoundException("Invalid Username");
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> isValid(@RequestBody LoginRequest loginRequest) {
        UserDto valid = userService.isValid(loginRequest.getUsername());

        if (valid != null && valid.getUsername().equalsIgnoreCase(loginRequest.getUsername())) {
            if (loginRequest.getPassword().equals(valid.getPassword())) {
                String token = redisTokenService.generateToken(valid.getId());
                redisTokenService.saveToken(valid.getId(), token);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", token);
                System.out.println(token);
                return ResponseEntity.ok().headers(headers).body(valid);
            } else {
                throw new InvalidPasswordException("Invalid password");
            }
        } else {
            if (valid == null) {
                throw new UserNotFoundException("Invalid Username");
            } else {
                throw new UserNotFoundException("Invalid username");
            }
        }
    }


    @PostMapping("/loginAdmin")
    public ResponseEntity<UserDto> adminLogin(@RequestBody AdminLoginRequest loginRequest) {
        UserDto valid = userService.isValidAdmin(loginRequest.getEmail());

        if (valid != null && valid.getEmail().equalsIgnoreCase(loginRequest.getEmail())) {
            if (loginRequest.getPassword().equals(valid.getPassword()) && valid.getIsAdmin()) {
                return ResponseEntity.ok(valid);
            } else {
                throw new InvalidPasswordException("Invalid password");
            }
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }


    @PostMapping("/resetToken")
    public ResponseEntity<String> resetToken(@RequestHeader String token) {
        String newToken = redisTokenService.resetToken(token);
        return ResponseEntity.ok(newToken);
    }

    @PostMapping("/checkCard")
    public ResponseEntity<String> isValidCard(@RequestBody UserEmailAndCardNumberRequest userRequest) {
        User userDto = userService.isValidEmailAndCardNumber(userRequest.getEmail(), userRequest.getCardNumber());
        if (userDto.getCardNumber().equals(userRequest.getCardNumber()) || userDto.getCardNumber().equals(userRequest.getCardNumber())) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully!");
        }
        throw new UserNotFoundException("User Not Found");
    }

}
