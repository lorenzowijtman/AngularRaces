package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.RacedriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RaceDriverRepository extends CrudRepository<RacedriverEntity, Integer> {
    boolean existsByIddriverAndIdrace(@Param("iddriver") int iddriver, @Param("idrace") int idrace);
    Iterable<RacedriverEntity> findAllByIdrace(@Param("idrace") int idrace);
    Iterable<RacedriverEntity> findAllByIdraceAndIddriver(@Param("idrace") int idrace, @Param("iddriver") int iddriver);
}
