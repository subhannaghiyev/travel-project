package az.spring.controller;

import az.spring.entity.TravelPicturesHome;
import az.spring.service.TravelPicturesHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/travels")
@CrossOrigin(origins = "http://localhost:3000")
public class TravelPicturesHomeController{

    private final TravelPicturesHomeService travelPicturesHomeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TravelPicturesHome> getAllTravels(){
       return travelPicturesHomeService.getAllTravels();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTravel(@RequestBody TravelPicturesHome travelPicturesHome){
        travelPicturesHomeService.saveTravel(travelPicturesHome);
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public void updateTravel(@RequestBody TravelPicturesHome travelPicturesHome ,@PathVariable Long id){
        travelPicturesHomeService.updateTravel(travelPicturesHome,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTravel(@PathVariable Long id){
        travelPicturesHomeService.deleteTravel(id);
    }
    @GetMapping("/{id}")
    public TravelPicturesHome getByIdTravel(@PathVariable Long id){
        return travelPicturesHomeService.getByIdTravel(id);
    }


}
