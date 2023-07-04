package az.spring.service;

import az.spring.entity.NewsData;
import az.spring.entity.OffersData;

import java.util.List;

public interface NewsDataService {

    List<NewsData> getAllNews();

    void saveNews(NewsData newsData);

    void updateNews(NewsData newsData , Long id);

    void deleteNews(Long id);

    NewsData getByIdNews(Long id);
}
