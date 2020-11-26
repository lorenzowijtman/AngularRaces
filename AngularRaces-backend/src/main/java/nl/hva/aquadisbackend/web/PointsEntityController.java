package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.PointsEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.PointsRepository;
import nl.hva.aquadisbackend.repo.UsergroupRepository;
import nl.hva.aquadisbackend.services.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/points")
public class PointsEntityController {
    PointsRepository pointsRepository;
    PointsService pointsService;
    UsergroupRepository usergroupRepository;

    protected PointsEntityController(){}

    @Autowired
    public PointsEntityController(PointsRepository pointsRepository, UsergroupRepository usergroupRepository) {
        this.pointsRepository = pointsRepository;
        this.pointsService = new PointsService(pointsRepository);
        this.usergroupRepository = usergroupRepository;
    }

    /*
    creates a new points entity in the database
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path="/newpoints/{groupid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPoints(Integer gamePoints, int idpoints,
                             @PathVariable(value="groupid") int groupId){
        Iterable<UsergroupEntity> usergroups = usergroupRepository.findAllByIdgroup(groupId);
        for(UsergroupEntity e: usergroups) {
            pointsService.createPoints(gamePoints, idpoints, e);
        }
    }

    /*
    returns all the points from form a specific user-group
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getall/{groupid}")
    public ArrayList<PointsEntity> getAllPointsByUsergroup(@PathVariable(value="groupid") int groupId){
        ArrayList<PointsEntity> points = new ArrayList<>();
        Iterable<UsergroupEntity> usergroups = usergroupRepository.findAllByIdgroup(groupId);
        for(UsergroupEntity e: usergroups) {
            points.add(pointsRepository.findByUsergroup(e));
        }
        return points;
    }
}
