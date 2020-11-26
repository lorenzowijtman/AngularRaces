package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.RacedriverEntity;
import nl.hva.aquadisbackend.repo.RaceDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RaceDriverService {
    private RaceDriverRepository raceDriverRepository;

    @Autowired
    public RaceDriverService(RaceDriverRepository raceDriverRepository) {
        this.raceDriverRepository = raceDriverRepository;
    }

    public RacedriverEntity createResult(int idrace, int iddriver, int startingPosition, int finishPosition, boolean finished) {
        if(!raceDriverRepository.existsByIddriverAndIdrace(iddriver, idrace)) {
            return raceDriverRepository.save(new RacedriverEntity(idrace, iddriver, startingPosition, finishPosition, finished));
        } else {
            return null;
        }
    }
}
