package az.spring.repository;

import az.spring.entity.OffersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface OffersDataRepository extends JpaRepository<OffersData, Long> {
}
