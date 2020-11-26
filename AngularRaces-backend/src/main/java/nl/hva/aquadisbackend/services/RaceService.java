package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.RaceEntity;
import nl.hva.aquadisbackend.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class RaceService {
    private RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository){this.raceRepository = raceRepository;}

    public RaceRepository createRace(int idrace, Timestamp date, String location, int idgroup) {
        if(!raceRepository.existsById(idrace)) {
            return (RaceRepository) raceRepository.save(new RaceEntity(idrace, date, location, idgroup));
        } else {
            return null;
        }
    }

    public Iterable<RaceEntity> lookup() {return raceRepository.findAll();}
    public long total() {return raceRepository.count();}
}
