package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.repo.TeamSelectionDriverRepository;
import nl.hva.aquadisbackend.services.TeamSelectionDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/teamselectiondriver")
public class TeamSelectionDriverController {

    TeamSelectionDriverRepository teamSelectionDriverRepository;
    TeamSelectionDriverService teamSelectionDriverService;

    protected TeamSelectionDriverController(){}

    @Autowired
    public TeamSelectionDriverController(TeamSelectionDriverRepository teamSelectionDriverRepository) {
        this.teamSelectionDriverRepository = teamSelectionDriverRepository;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/new/{idteamselection}/{iduser}/{iddriver}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeamSelectiondriver(@PathVariable("idteamselection") Integer idteamSelection,
                                          @PathVariable("iduser") Integer iduser, @PathVariable("iddriver")
                                                      Integer iddriver) {
        this.teamSelectionDriverService = new TeamSelectionDriverService(this.teamSelectionDriverRepository);
        teamSelectionDriverService.createSelection(idteamSelection, iduser, iddriver);
    }

}
