package az.spring.service.impl;

import az.spring.entity.OffersData;
import az.spring.repository.OffersDataRepository;
import az.spring.service.OffersDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffersDataServiceImpl implements OffersDataService {
    private final OffersDataRepository offersDataRepository;


    @Override
    public List<OffersData> getAllOffers() {
        return offersDataRepository.findAll();
    }

    @Override
    public void saveOffers(OffersData offersData) {
        offersDataRepository.save(offersData);
    }

    @Override
    public void updateOffers(OffersData offersData, Long id) {
        OffersData existingOffers = offersDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        existingOffers.setImg(offersData.getImg());
        existingOffers.setInfo(offersData.getInfo());
        existingOffers.setPrice(offersData.getPrice());
        existingOffers.setDescription(offersData.getDescription());
        existingOffers.setCountry(offersData.getCountry());

        offersDataRepository.save(existingOffers);
    }

    @Override
    public void deleteOffers(Long id) {
        offersDataRepository.deleteById(id);
    }

    @Override
    public OffersData getByIdOffers(Long id) {
        OffersData existingTravel = offersDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel not found with ID: " + id));
        return existingTravel;
    }
}
