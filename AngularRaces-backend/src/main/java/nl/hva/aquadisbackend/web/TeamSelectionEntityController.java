package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.DriverEntity;
import nl.hva.aquadisbackend.models.TeamSelectionEntity;
import nl.hva.aquadisbackend.repo.DriverRepository;
import nl.hva.aquadisbackend.repo.RaceDriverRepository;
import nl.hva.aquadisbackend.repo.TeamSelectionDriverRepository;
import nl.hva.aquadisbackend.repo.TeamSelectionrepository;
import nl.hva.aquadisbackend.services.TeamSelectionDriverService;
import nl.hva.aquadisbackend.services.TeamSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/teamselections")
public class TeamSelectionEntityController {
    TeamSelectionrepository teamSelectionrepository;
    TeamSelectionService teamSelectionService;
    TeamSelectionDriverRepository teamSelectionDriverRepository;
    TeamSelectionDriverService teamSelectionDriverService;
    DriverRepository driverRepository;

    protected TeamSelectionEntityController(){}

    @Autowired
    public TeamSelectionEntityController(TeamSelectionrepository teamSelectionrepository, TeamSelectionDriverRepository teamSelectionDriverRepository, DriverRepository driverRepository) {
        this.teamSelectionrepository = teamSelectionrepository;
        this.teamSelectionDriverRepository = teamSelectionDriverRepository;
        this.driverRepository = driverRepository;
        this.teamSelectionDriverService = new TeamSelectionDriverService(teamSelectionDriverRepository);
        this.teamSelectionService = new TeamSelectionService(teamSelectionrepository);
    }

    //creates a new teamselection entity
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path="/new/{idteamselection}/{name}/{budget}/{iduser}/{VP}/{driverOne}/{driverTwo}/{driverThree}/{driverFour}/{driverFive}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeamSelection(@PathVariable("idteamselection") Integer idteamSelection,
                                    @PathVariable("name") String name, @PathVariable("budget") Integer budget,
                                    @PathVariable("VP") Integer verstappenPosition,
                                    @PathVariable("iduser") Integer iduser, @PathVariable("driverOne") String driverOne,
                                    @PathVariable("driverTwo") String driverTwo, @PathVariable("driverThree") String driverThree,
                                    @PathVariable("driverFour") String driverFour, @PathVariable("driverFive") String driverFive) {
        teamSelectionService.createTeamSelection(name, budget, verstappenPosition, iduser);
        String[] drivers = {driverOne, driverTwo, driverThree, driverFour, driverFive};
        for (int i = 0; i < drivers.length; i++) {
            DriverEntity driver = driverRepository.findByLastname(drivers[i]);
            teamSelectionDriverService.createSelection(idteamSelection, iduser, driver.getIddriver());
        }


    }

    //returns all team selection entitites
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<TeamSelectionEntity> getTeamSelections() { return teamSelectionrepository.findAll();}
}
