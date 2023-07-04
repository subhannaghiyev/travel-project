package az.spring.service.impl;

import az.spring.entity.NewsData;
import az.spring.entity.OffersData;
import az.spring.repository.NewsDataRepository;
import az.spring.repository.OffersDataRepository;
import az.spring.service.NewsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsDataServiceImpl implements NewsDataService {
    private final NewsDataRepository newsDataRepository;


    @Override
    public List<NewsData> getAllNews() {
        return newsDataRepository.findAll();
    }

    @Override
    public void saveNews(NewsData newsData) {
        newsDataRepository.save(newsData);
    }

    @Override
    public void updateNews(NewsData newsData, Long id) {
        NewsData existingNews = newsDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        existingNews.setImg(newsData.getImg());
        existingNews.setDescription(newsData.getDescription());

        newsDataRepository.save(existingNews);
    }

    @Override
    public void deleteNews(Long id) {
        newsDataRepository.deleteById(id);
    }

    @Override
    public NewsData getByIdNews(Long id) {
        NewsData existingNews = newsDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        return existingNews;
    }
}
