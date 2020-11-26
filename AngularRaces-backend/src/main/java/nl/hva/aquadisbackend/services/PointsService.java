package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.PointsEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PointsService {
    private PointsRepository pointsRepository;

    @Autowired
    public PointsService(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    public PointsEntity createPoints(Integer gamePoints, int idpoints, UsergroupEntity usergroup){
        if(!pointsRepository.existsById(idpoints)) {
            return pointsRepository.save(new PointsEntity(gamePoints, idpoints, usergroup));
        } else {
            return null;
        }
    }

    public Iterable<PointsEntity> lookup() {
        return pointsRepository.findAll();
    }

    public long total() {
        return pointsRepository.count();
    }
}
