package az.spring.service;

import az.spring.entity.OffersData;
import az.spring.entity.SliderData;

import java.util.List;

public interface OffersDataService {
    List<OffersData> getAllOffers();

    void saveOffers(OffersData offersData);

    void updateOffers(OffersData offersData , Long id);

    void deleteOffers(Long id);

    OffersData getByIdOffers(Long id);
}
