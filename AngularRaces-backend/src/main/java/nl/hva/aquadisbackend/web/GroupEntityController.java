package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.GameGroupEntity;
import nl.hva.aquadisbackend.models.PointsEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.GroupRepository;
import nl.hva.aquadisbackend.repo.PointsRepository;
import nl.hva.aquadisbackend.repo.UsergroupRepository;
import nl.hva.aquadisbackend.services.GroupService;
import nl.hva.aquadisbackend.services.PointsService;
import nl.hva.aquadisbackend.services.UsergroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path="/gamegroups")
public class GroupEntityController {
    GroupRepository groupRepository;
    UsergroupRepository usergroupRepository;
    PointsRepository pointsRepository;

    protected GroupEntityController(){}

    @Autowired
    public GroupEntityController(GroupRepository groupRepository, UsergroupRepository usergroupRepository,
                                 PointsRepository pointsRepository) {
        this.groupRepository = groupRepository;
        this.usergroupRepository = usergroupRepository;
        this.pointsRepository = pointsRepository;
    }
    /*
    creates a new group in the database
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path ="/add/{id}/{name}/{adminId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@PathVariable (value="id")Integer id, @PathVariable(value="name") String name,
                            @PathVariable(value="adminId") Integer admin_id) {
        GroupService gs = new GroupService(groupRepository);
        UsergroupService ugs = new UsergroupService(usergroupRepository);
        PointsService ps = new PointsService(pointsRepository);
        byte b = 0;
        gs.createGroup(id,name,admin_id);
        UsergroupEntity uge = ugs.createUsergroup(admin_id, id, b);
        ps.createPoints(0,id, uge);
    }

    /*
    gets all groups form the database
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<GameGroupEntity> getGroups() {
        return groupRepository.findAll();
    }

    /*
    returns all the groups of a specific user by the id of the user
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/{iduser}/allgroups")
    public ArrayList<Optional<GameGroupEntity>> getGroupsByUserId(@PathVariable(value="iduser") int iduser) {
        Iterable<UsergroupEntity> usergroups = usergroupRepository.findAllByIduser(iduser);
        ArrayList<Optional<GameGroupEntity>> gamegroups = new ArrayList<>();
        for (UsergroupEntity u: usergroups) {
            gamegroups.add(groupRepository.findById(u.getIdgroup()));
        }
        return gamegroups;
    }
}
