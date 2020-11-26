package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.TeamSelectionEntity;
import nl.hva.aquadisbackend.repo.TeamSelectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamSelectionService {
    private TeamSelectionrepository teamSelectionrepository;

    @Autowired
    public TeamSelectionService(TeamSelectionrepository teamSelectionrepository) {this.teamSelectionrepository = teamSelectionrepository;}

    public TeamSelectionEntity createTeamSelection( String name, int budget, int verstappenPosition, int iduser) {

            return teamSelectionrepository.save(new TeamSelectionEntity(name, budget, verstappenPosition, iduser));

    }

    Iterable<TeamSelectionEntity> lookup() {return teamSelectionrepository.findAll();}

    public long total() {return teamSelectionrepository.count();}
}
