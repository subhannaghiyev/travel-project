package az.spring.controller;

import az.spring.entity.NewsData;
import az.spring.service.NewsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class NewsDataController {
    private final NewsDataService newsDataService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NewsData> getAllOffers(){
        return newsDataService.getAllNews();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOffers(@RequestBody NewsData newsData){
        newsDataService.saveNews(newsData);
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public void updateOffers(@RequestBody NewsData newsData ,@PathVariable Long id){
        newsDataService.updateNews(newsData,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOffers(@PathVariable Long id){
        newsDataService.deleteNews(id);
    }
    @GetMapping("/{id}")
    public NewsData getByIdTravel(@PathVariable Long id){
        return newsDataService.getByIdNews(id);
    }
}
