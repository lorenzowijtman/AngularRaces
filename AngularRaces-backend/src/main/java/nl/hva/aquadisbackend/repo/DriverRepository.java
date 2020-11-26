package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Integer> {
    DriverEntity findByLastname(@Param("lastname") String lastname);
    DriverEntity findByIddriver(@Param("iddriver") int iddriver);
}
