package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.DriverEntity;
import nl.hva.aquadisbackend.repo.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverService {
    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {this.driverRepository = driverRepository;}

    public DriverEntity createDriver(int id, String firstname, String lastname, int cost) {
        if (!driverRepository.existsById(id)) {
            return driverRepository.save(new DriverEntity(firstname, lastname, cost, id));
        } else {
            return null;
        }
    }

    public Iterable<DriverEntity> lookup() {
        return driverRepository.findAll();
    }

    public long total() {
        return driverRepository.count();
    }
}
