package az.spring.repository;

import az.spring.entity.NewsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDataRepository extends JpaRepository<NewsData , Long> {
}
