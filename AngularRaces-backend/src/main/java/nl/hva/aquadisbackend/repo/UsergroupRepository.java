package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.UsergroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsergroupRepository extends CrudRepository<UsergroupEntity, Integer> {

    Iterable<UsergroupEntity> findAllByIduser(@Param("iduser") int iduser);
    Iterable<UsergroupEntity> findAllByIdgroup(@Param("idgroup") int idgroup);
}
