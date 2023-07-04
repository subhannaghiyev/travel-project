package az.spring.repository;

import az.spring.entity.TravelPicturesHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPicturesHomeRepository  extends JpaRepository<TravelPicturesHome,Long> {
}
