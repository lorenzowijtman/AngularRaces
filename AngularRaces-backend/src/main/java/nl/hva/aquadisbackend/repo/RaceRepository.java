package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.RaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RaceRepository extends CrudRepository<RaceEntity, Integer> {

    RaceEntity findByDate(@Param("date") Date date);
    Iterable<RaceEntity> findByIdgroup(@Param("idgroup") int idgroup);
}
