package az.spring.repository;

import az.spring.entity.AdminMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMessageRepository extends JpaRepository<AdminMessage , Long> {
}
