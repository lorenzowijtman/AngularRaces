package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.GameGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GameGroupEntity, Integer> {
    //adds param to API request for finding group by name

    GameGroupEntity findByName(@Param("name") String name);
}
