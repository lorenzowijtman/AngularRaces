package nl.hva.aquadisbackend.repo;

import nl.hva.aquadisbackend.models.TeamSelectionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamSelectionrepository extends CrudRepository<TeamSelectionEntity, Integer> {
}
