package az.spring.service;

import az.spring.entity.SliderData;
import az.spring.entity.TravelPicturesHome;

import java.util.List;

public interface SliderDataService{

    List<SliderData> getAllSlider();

    void saveSlider(SliderData sliderData);

    void updateSlider(SliderData sliderData , Long id);

    void deleteSlider(Long id);

    SliderData getByIdSlider(Long id);
}
