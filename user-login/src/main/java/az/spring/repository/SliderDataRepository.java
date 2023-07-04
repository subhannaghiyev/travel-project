package az.spring.repository;

import az.spring.entity.SliderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderDataRepository  extends JpaRepository<SliderData,Long> {

}
