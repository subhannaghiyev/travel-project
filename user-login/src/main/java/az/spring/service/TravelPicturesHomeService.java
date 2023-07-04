package az.spring.service;

import az.spring.entity.TravelPicturesHome;

import java.util.List;

public interface TravelPicturesHomeService {

    List<TravelPicturesHome> getAllTravels();

    void saveTravel(TravelPicturesHome travelPicturesHome);

    void updateTravel(TravelPicturesHome travelPicturesHome , Long id);

    void deleteTravel(Long id);

    TravelPicturesHome getByIdTravel(Long id);

}
