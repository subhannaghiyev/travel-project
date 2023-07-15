package az.spring.service.impl;

import az.spring.entity.User;
import az.spring.exception.UserNotFoundException;
import az.spring.mapper.UserMapper;
import az.spring.mapper.UserModel;
import az.spring.model.*;
import az.spring.repository.UserRepository;
import az.spring.service.UserService;
import az.spring.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public List<UserRequest> getAllUsers() {
        var users = userRepository.findAll();

        List<UserRequest> userRequestList = new ArrayList<>();

        for (User user : users) {
            userRequestList.add(UserModel.STUDENT_BUILDER.buildEntityRequest(user));
        }
        return userRequestList;
    }

    @Override
    public UserRequest getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id is not exists"));
        if (!user.getIsActive()) {
            throw new UserNotFoundException("User not found");
        }
        return userMapper.mapEntityToRequest(user);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = UserModel.STUDENT_BUILDER.buildDto(userDto);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id is not exists"));

        User updatedUser = userMapper.mapDtoToEntity(userDto);
        updatedUser.setId(existingUser.getId());

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setIsActive(updatedUser.getIsActive());
        existingUser.setUsername(updatedUser.getUsername());

        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id is not exists"));
        user.setIsActive(false);
        userRepository.save(user);
    }

    @Override
    public UserDto isValid(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getUsername().equalsIgnoreCase(username)) {
            return UserModel.STUDENT_BUILDER.buildEntity(user);
        } else {
            return null;
        }
    }

        @Override
    public UserDto isValidAdmin(String email) {
        User admin = userRepository.findByEmailAndIsAdmin(email ,true);
        System.out.println(admin);
        return UserModel.STUDENT_BUILDER.buildEntity(admin);
    }
//    public UserDto isValidAdmin(String email) {
//        List<User> admins = userRepository.findByEmailAndIsAdmin(email, true);
//
//        if (admins.isEmpty()) {
//            return null; // veya isteğe bağlı bir değer döndürebilirsiniz
//        }
//
//        User admin = admins.get(0); // İlk bulunan admin kullanıcısını al
//
//        return UserModel.STUDENT_BUILDER.buildEntity(admin);
//    }


    @Override
    public List<User> getFilteredUsers(UserCriteria userCriteria) {
        Specification<User> specification = new UserSpecification(userCriteria);
        return userRepository.findAll(specification);
    }

    @Override
    public void saveCard(UserCardRequest userCardRequest) {
        User user = UserModel.STUDENT_BUILDER.buildCardRequest(userCardRequest);
        userRepository.save(user);
    }

    @Override
    public User isValidEmailAndCardNumber(String email, Long cardNumber) {
        User user = userRepository.findByEmailAndCardNumber(email, cardNumber);
        System.out.println(user);
        return user;
    }


}
