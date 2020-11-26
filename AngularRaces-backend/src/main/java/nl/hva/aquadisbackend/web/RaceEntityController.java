package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.RaceEntity;
import nl.hva.aquadisbackend.repo.RaceRepository;
import nl.hva.aquadisbackend.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path="/races")
public class RaceEntityController {
        RaceRepository raceRepository;
        RaceService raceService;

        @PersistenceContext
        private EntityManager entityManager;

        public final static String NEXT_3_RACES = "SELECT * FROM `persistencepractise`.`race` WHERE `date` > CURDATE() AND `idgroup` = :id LIMIT 3;";
        public final static String LAST_3_RACES = "SELECT * FROM `persistencepractise`.`race` WHERE `date` < CURDATE() AND `idgroup` = :id LIMIT 3;";

        protected RaceEntityController(){}

        @Autowired
        public RaceEntityController(RaceRepository raceRepository) {
            this.raceRepository = raceRepository;
        }


        //creates a new race object in the database
        @CrossOrigin
        @RequestMapping(method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public void createRace(int idrace, Timestamp date, String location, int idgroup) {
            raceService.createRace(idrace, date, location, idgroup);
        }

        //returns all races
        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET)
            public Iterable<RaceEntity> getRaces() {return raceRepository.findAll();
        }

        //returns all races that belong to a group
        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET, path="/idGroup/{idgroup}")
        public Iterable<RaceEntity> getUserIdByNickname(@PathVariable("idgroup") int idgroup) {
            return raceRepository.findByIdgroup(idgroup);
        }

        //returns next 3 races that belong to a group
        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET, path="/3UpcomingRaces/{id}")
        public List<RaceEntity> getNext3Races(@PathVariable("id") int id) {
            Query nativeQuery = entityManager.createNativeQuery(NEXT_3_RACES).setParameter("id",id);
            return nativeQuery.getResultList();
        }

        //returns last 3 races that belong to a group
        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET, path="/3LastRaces/{id}")
        public List<RaceEntity> getPrevious3Races(@PathVariable("id") int id) {
                Query nativeQuery = entityManager.createNativeQuery(LAST_3_RACES).setParameter("id",id);
                return nativeQuery.getResultList();
        }
    }

