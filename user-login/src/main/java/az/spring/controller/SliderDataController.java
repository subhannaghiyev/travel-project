package az.spring.controller;

import az.spring.entity.SliderData;
import az.spring.service.SliderDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sliders")
@CrossOrigin(origins = "http://localhost:3000")
public class SliderDataController {
    private final SliderDataService sliderDataService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SliderData> getAllSlider(){
        return sliderDataService.getAllSlider();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSlider(@RequestBody SliderData sliderData){
        sliderDataService.saveSlider(sliderData);
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public void updateSlider(@RequestBody SliderData sliderData ,@PathVariable Long id){
        sliderDataService.updateSlider(sliderData,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSlider(@PathVariable Long id){
        sliderDataService.deleteSlider(id);
    }
    @GetMapping("/{id}")
    public SliderData getByIdTravel(@PathVariable Long id){
        return sliderDataService.getByIdSlider(id);
    }
}
