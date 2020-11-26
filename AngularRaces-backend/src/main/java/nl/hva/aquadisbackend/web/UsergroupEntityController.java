package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.GameGroupEntity;
import nl.hva.aquadisbackend.models.UserEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.GroupRepository;
import nl.hva.aquadisbackend.repo.PointsRepository;
import nl.hva.aquadisbackend.repo.UserRepository;
import nl.hva.aquadisbackend.repo.UsergroupRepository;
import nl.hva.aquadisbackend.services.UsergroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path="/usergroups")
public class UsergroupEntityController {
    UsergroupRepository usergroupRepository;
    UsergroupService usergroupService;
    GroupRepository groupRepository;
    UserRepository userRepository;
    PointsRepository pointsRepository;

    protected UsergroupEntityController(){}

    @Autowired
    public UsergroupEntityController(UsergroupRepository usergroupRepository, GroupRepository groupRepository,
                                     UserRepository userRepository, PointsRepository pointsRepository) {
        this.usergroupRepository = usergroupRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.pointsRepository = pointsRepository;
    }

    // creates a new usergroup in the database
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUsergroup(int iduser, int idgroup, byte isAdmin) {
        usergroupService.createUsergroup(iduser, idgroup, isAdmin);
    }

    // returns all the usergroups of a specific user
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/id/{iduser}")
    public ArrayList<Optional<GameGroupEntity>> getUsergroups(@PathVariable(value="iduser") String iduser) {
        ArrayList<Optional<GameGroupEntity>> gamegroups = new ArrayList<>();
         Iterable<UsergroupEntity> usergroups = usergroupRepository.findAllByIduser(Integer.parseInt(iduser));
         for(UsergroupEntity u: usergroups) {
            Optional<GameGroupEntity> ent = groupRepository.findById(u.getIdgroup());
             gamegroups.add(ent);
         }
         return gamegroups;
    }

    //returns all usergroups
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public Iterable<UsergroupEntity> getAllUserGroups(){return usergroupRepository.findAll();}

    //returns all users from the specified usergroup
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{idgroup}/allusers")
    public ArrayList<Optional<UserEntity>> getAllUsersInGroup(@PathVariable(value="idgroup")int idgroup){
        ArrayList<Optional<UserEntity>> users = new ArrayList<>();
        Iterable<UsergroupEntity> usersInGroup = usergroupRepository.findAllByIdgroup(idgroup);
        for(UsergroupEntity u: usersInGroup) {
            users.add(userRepository.findById(u.getIduser()));
        }
        return users;
    }
}
