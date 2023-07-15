package az.spring.mapper;

import az.spring.entity.User;
import az.spring.model.UserCardRequest;
import az.spring.model.UserDto;
import az.spring.model.UserEmailAndCardNumberRequest;
import az.spring.model.UserRequest;
import az.spring.utils.PasswordUtils;

public enum UserModel {
    STUDENT_BUILDER;


    public final User buildDto(UserDto userDto) {
        Boolean isAdmin = (userDto.getIsAdmin() != null) ? userDto.getIsAdmin() : false;


        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .isActive(userDto.getIsActive() != null ? userDto.getIsActive() : true)
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .isAdmin(isAdmin)
                .cardNumber(userDto.getCardNumber())
                .address(userDto.getAddress())
                .country(userDto.getCountry())
                .date(userDto.getDate())
                .nameCard(userDto.getNameCard())
                .cvv(userDto.getCvv())
                .build();
    }
    public final UserDto buildEntity(User user) {
        Boolean isAdmin = (user.getIsAdmin() != null) ? user.getIsAdmin() : false;


        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .isActive(user.getIsActive() != null ? user.getIsActive() : true)
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .isAdmin(isAdmin)
                .cardNumber(user.getCardNumber())
                .address(user.getAddress())
                .country(user.getCountry())
                .date(user.getDate())
                .nameCard(user.getNameCard())
                .cvv(user.getCvv())
                .build();
    }

    public final UserRequest buildEntityRequest(User user) {
//        Boolean isAdmin = (user.getIsAdmin() != null) ? user.getIsAdmin() : false;


        return UserRequest.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .isActive(user.getIsActive() != null ? user.getIsActive() : true)
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
//                .isAdmin(isAdmin)
                .cardNumber(user.getCardNumber())
                .address(user.getAddress())
                .country(user.getCountry())
                .date(user.getDate())
                .nameCard(user.getNameCard())
                .cvv(user.getCvv())
                .build();
    }

    public final User buildCardRequest(UserCardRequest userCardRequest) {
//        Boolean isAdmin = (userCardRequest.getIsAdmin() != null) ? userDto.getIsAdmin() : false;


        return User.builder()
                .id(userCardRequest.getId())
                .nameCard(userCardRequest.getNameCard())
                .isActive(userCardRequest.getIsActive() != null ? userCardRequest.getIsActive() : true)
                .email(userCardRequest.getEmail())
                .cardNumber(userCardRequest.getCardNumber())
                .cvv(userCardRequest.getCvv())
                .date(userCardRequest.getDate())
                .address(userCardRequest.getAddress())
                .build();
    }

    public final UserCardRequest buildCard(User user) {
//        Boolean isAdmin = (userCardRequest.getIsAdmin() != null) ? userDto.getIsAdmin() : false;


        return UserCardRequest.builder()
                .id(user.getId())
                .nameCard(user.getNameCard())
                .isActive(user.getIsActive() != null ? user.getIsActive() : true)
                .email(user.getEmail())
                .cardNumber(user.getCardNumber())
                .cvv(user.getCvv())
                .date(user.getDate())
                .address(user.getAddress())
                .build();
    }

    public final UserEmailAndCardNumberRequest emailAndCard(User user) {
//        Boolean isAdmin = (userCardRequest.getIsAdmin() != null) ? userDto.getIsAdmin() : false;


        return UserEmailAndCardNumberRequest.builder()
                .email(user.getEmail())
                .cardNumber(user.getCardNumber())
                .build();
    }

}
