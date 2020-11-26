package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.*;
import nl.hva.aquadisbackend.repo.*;
import nl.hva.aquadisbackend.services.RaceDriverService;
import nl.hva.aquadisbackend.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/results")
public class RaceDriverController {
    RaceDriverRepository raceDriverRepository;
    RaceDriverService raceDriverService;

    RaceRepository raceRepository;
    GroupRepository groupRepository;
    UserRepository userRepository;
    TeamSelectionrepository teamSelectionrepository;
    TeamSelectionDriverRepository teamSelectionDriverRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private List<RacedriverEntity> resultList;

    private final static String queryGetResultsPlusNameDrive = "SELECT driver.firstname, driver.lastname, racedriver.finish_position " +
            "FROM driver INNER JOIN racedriver ON driver.iddriver = racedriver.iddriver " +
            "WHERE racedriver.idrace = :idRace ORDER BY racedriver.finish_position;";

    protected RaceDriverController() {
    }

    @Autowired
    public RaceDriverController(RaceDriverRepository raceDriverRepository, RaceRepository raceRepository,
                                GroupRepository groupRepository, UserRepository userRepository,
                                TeamSelectionrepository teamSelectionrepository,
                                TeamSelectionDriverRepository teamSelectionDriverRepository) {
        this.resultList = new ArrayList<>();
        this.raceDriverRepository = raceDriverRepository;
        this.raceDriverService = new RaceDriverService(raceDriverRepository);
        this.raceRepository = raceRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.teamSelectionrepository = teamSelectionrepository;
        this.teamSelectionDriverRepository = teamSelectionDriverRepository;

    }

    /*
    creates a new result for a driver in the database for a race
     */
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.POST, path = "/new/{idrace}/{iddriver}/{startingPosition}/{finishPosition}/{finished}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createResult(@PathVariable("idrace") Integer idrace, @PathVariable("iddriver") Integer iddriver,
//                             @PathVariable("startingPosition") Integer startingPosition,
//                             @PathVariable("finishPosition") Integer finishPosition, @PathVariable("finished") boolean finished) {
//        RacedriverEntity tempRacer = new RacedriverEntity(idrace, iddriver, startingPosition, finishPosition, finished);
//        resultList.add(tempRacer);
//        raceDriverService.createResult(idrace, iddriver, startingPosition, finishPosition, finished);
//
//    }


    /**
    creates a new result for a driver in the database for a race
     **/
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/new/{body}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createResult(@PathVariable("body") List<Object> body){
        System.out.println("test");
        for (Object o : body) {
            System.out.println(o);
//            this.resultList.add(new RacedriverEntity());
//            raceDriverService.createResult(r.getIdrace(), r.getIddriver(), r.getStartingPosition(), r.getFinishPosition(), r.getFinished());
        }

        for (RacedriverEntity r : this.resultList) {
            System.out.printf("Racer %d  Position %d Finished %b",r.getIddriver(),r.getFinishPosition(), r.getFinished());
        }
//        RacedriverEntity tempRacer = new RacedriverEntity(idrace, iddriver, startingPosition, finishPosition, finished);
//        resultList.add(tempRacer);
//        raceDriverService.createResult(idrace, iddriver, startingPosition, finishPosition, finished);

    }

    /**
     * This method will calculate the scores each user will get from the race
     **/
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/finished")
    @ResponseStatus(HttpStatus.CREATED)
    public void calculatePoints() {
        System.out.println("AANDACHT!!!");
        for (RacedriverEntity r : resultList) {
            int score = 0;
            // give 5 points to pole position
            if (r.getStartingPosition() == 1) {
                score += 5;
            }

            // calculate finish position score
            score += 21 - r.getFinishPosition();

            //
            if (!r.getFinished()) {
                score -= 10;
            }

            if (r.getFinishPosition() == 1) {
                score += 5;
            }

            Optional<RaceEntity> re = raceRepository.findById(r.getIdrace());
            Optional<GameGroupEntity> ge = groupRepository.findById(re.get().getIdgroup());

            String sql = "SELECT UG.iduser FROM racedriver AS RD\n" +
                    "INNER JOIN race AS R ON RD.idrace = R.idrace\n" +
                    "INNER JOIN game_group AS GG ON R.idgroup = GG.idgroup\n" +
                    "INNER JOIN usergroup AS UG ON GG.idgroup = UG.idgroup\n" +
                    "INNER JOIN team_selection AS TS ON UG.iduser = TS.iduser\n" +
                    "WHERE RD.iddriver = " + r.getIddriver() + "\n" +
                    "GROUP BY UG.iduser";

            Query nativeQuery = entityManager.createNativeQuery(sql);
            List<Integer> result = nativeQuery.getResultList();

            for (Integer i : result) {
                String sql2 = "UPDATE points \n" +
                        "SET game_points = game_points + " + score + "\n" +
                        "WHERE iduser = " + userRepository.findById(i).get().getIduser();

                entityManager.createNativeQuery(sql2);

            }
        }
        resultList.clear();
    }


    /*
    returns all the results from a specific race

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{idrace}")
    public Iterable<RacedriverEntity> getResultsFromRace(@PathVariable(value="idrace") int idrace) {
        return raceDriverRepository.findAllByIdrace(idrace);
    }
*/
    /*
    returns all results from the specified race and group
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{idrace}/{idgroup}")
    public Iterable<RacedriverEntity> getResultsFromRace(@PathVariable(value = "idrace") int idRace,
                                                         @PathVariable(value = "idgroup") int idGroup) {
        return raceDriverRepository.findAllByIdraceAndIddriver(idRace, idGroup);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{idrace}")
    public Iterable<Object> customQuery(@PathVariable(value = "idrace") String idRace) {
        Query nativeQeury = entityManager.createNativeQuery(queryGetResultsPlusNameDrive).setParameter("idRace", idRace);
        return nativeQeury.getResultList();
    }
}
