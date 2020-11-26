package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.TeamSelectiondriverEntity;
import nl.hva.aquadisbackend.repo.TeamSelectionDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamSelectionDriverService {
    private TeamSelectionDriverRepository teamSelectionDriverRepository;

    @Autowired
    public TeamSelectionDriverService(TeamSelectionDriverRepository teamSelectionDriverRepository) {
        this.teamSelectionDriverRepository = teamSelectionDriverRepository;
    }

    public TeamSelectiondriverEntity createSelection(int idteamSelection, int iduser, int iddriver) {
        return teamSelectionDriverRepository.save(new TeamSelectiondriverEntity(idteamSelection,iduser, iddriver));
    }

    public Iterable<TeamSelectiondriverEntity> lookup() {
        return teamSelectionDriverRepository.findAll();
    }
}
