package az.spring.controller;

import az.spring.entity.OffersData;
import az.spring.service.OffersDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class OffersDataController {

    private final OffersDataService offersDataService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OffersData> getAllOffers(){
        return offersDataService.getAllOffers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOffers(@RequestBody OffersData offersData){
        offersDataService.saveOffers(offersData);
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public void updateOffers(@RequestBody OffersData offersData ,@PathVariable Long id){
        offersDataService.updateOffers(offersData,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOffers(@PathVariable Long id){
        offersDataService.deleteOffers(id);
    }
    @GetMapping("/{id}")
    public OffersData getByIdTravel(@PathVariable Long id){
        return offersDataService.getByIdOffers(id);
    }
}
