package az.spring.service.impl;

import az.spring.entity.TravelPicturesHome;
import az.spring.repository.TravelPicturesHomeRepository;
import az.spring.service.TravelPicturesHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TravelPicturesHomeServiceImpl implements TravelPicturesHomeService {


    private final TravelPicturesHomeRepository travelPicturesHomeRepository;


    @Override
    public List<TravelPicturesHome> getAllTravels() {
        return travelPicturesHomeRepository.findAll();
    }

    @Override
    public void saveTravel(TravelPicturesHome travelPicturesHome) {
        travelPicturesHomeRepository.save(travelPicturesHome);
    }

    @Override
    public void updateTravel(TravelPicturesHome travelPicturesHome, Long id) {
        TravelPicturesHome existingTravel = travelPicturesHomeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        existingTravel.setImg(travelPicturesHome.getImg());
        existingTravel.setPrice(travelPicturesHome.getPrice());
        existingTravel.setCountry(travelPicturesHome.getCountry());
        existingTravel.setCapital(travelPicturesHome.getCapital());

        travelPicturesHomeRepository.save(existingTravel);
    }

    @Override
    public void deleteTravel(Long id) {
        travelPicturesHomeRepository.deleteById(id);
    }

    @Override
    public TravelPicturesHome getByIdTravel(Long id) {
        TravelPicturesHome existingTravel = travelPicturesHomeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        return existingTravel;
    }
}
