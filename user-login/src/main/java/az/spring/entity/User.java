package az.spring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
@Where(clause = "is_active = true")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    Long age;
    Boolean isActive;
    String username;
    @Column(unique = true)
    String email;
    String password;
    Boolean isAdmin;
    String nameCard;
    String country;
    Long cardNumber;
    LocalDate date;
    Long cvv;
    String address;

//    public void setPassword(String password) {
//        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//        this.password = hashedPassword;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
