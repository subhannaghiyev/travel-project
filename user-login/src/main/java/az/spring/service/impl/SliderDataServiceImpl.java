package az.spring.service.impl;

import az.spring.entity.SliderData;
import az.spring.repository.SliderDataRepository;
import az.spring.service.SliderDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SliderDataServiceImpl implements SliderDataService {

    private final SliderDataRepository sliderDataRepository;


    @Override
    public List<SliderData> getAllSlider() {
        return sliderDataRepository.findAll();
    }

    @Override
    public void saveSlider(SliderData sliderData) {
        sliderDataRepository.save(sliderData);
    }

    @Override
    public void updateSlider(SliderData sliderData, Long id) {
        SliderData existingTravel = sliderDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        existingTravel.setImg(sliderData.getImg());
        existingTravel.setDescription(sliderData.getDescription());
        existingTravel.setCountry(sliderData.getCountry());

        sliderDataRepository.save(existingTravel);
    }

    @Override
    public void deleteSlider(Long id) {
        sliderDataRepository.deleteById(id);
    }

    @Override
    public SliderData getByIdSlider(Long id) {
        SliderData existingTravel = sliderDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        return existingTravel;
    }
}
