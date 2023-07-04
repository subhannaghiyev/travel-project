package az.spring.repository;

import az.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

    User findByUsername(@RequestParam("username") String username);

//    @Query(value = "SELECT * FROM users WHERE email = :email LIMIT 1", nativeQuery = true)
//    User findByEmail(@Param("email") String email);

    User findByEmailAndIsAdmin(String email ,Boolean isAdmin);
    @Query(value = "SELECT * FROM users WHERE email = :email AND card_number = :cardNumber", nativeQuery = true)
    User findByEmailAndCardNumber(@Param("email") String email, @Param("cardNumber") Long cardNumber);

}
