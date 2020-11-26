package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.PointsEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PointsRepository extends CrudRepository<PointsEntity, Integer> {

    PointsEntity findByUsergroup(@Param("usergroup")UsergroupEntity usergroup);

}
