package nl.hva.aquadisbackend.web;

import nl.hva.aquadisbackend.models.GameGroupEntity;
import nl.hva.aquadisbackend.models.UserEntity;
import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.GroupRepository;
import nl.hva.aquadisbackend.repo.UserRepository;
import nl.hva.aquadisbackend.repo.UsergroupRepository;
import nl.hva.aquadisbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path="/users")
public class UserEntityController {
    UserRepository userRepository;
    UserService userService;
    UsergroupRepository usergroupRepository;
    GroupRepository groupRepository;

    protected UserEntityController(){}
    @Autowired
    public UserEntityController(UserRepository userRepository, UsergroupRepository usergroupRepository,
                                GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.usergroupRepository = usergroupRepository;
        this.groupRepository = groupRepository;
    }

    //creates a new user in the database
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(String nickname, int id, String password, String email) {
        userService.createUser(id, nickname, email, password);
    }

    //returns all users
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    //returns specific user from specified email
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/{email}")
    public int getUserId(@PathVariable("email") String email) {
        return userRepository.findByEmail(email).getIduser();
    }

    //returns a user based on their nickname
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/userNickname/{nickname}")
    public int getUserIdByNickname(@PathVariable("nickname") String nickname) {
        return userRepository.findByNickname(nickname).getIduser();
    }

    //returns all users in a group
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path="/userGroup/{name}")
    public ArrayList<Optional<UserEntity>> getUserIdByGroupName(@PathVariable("name") String name) {
        ArrayList<Optional<UserEntity>> users = new ArrayList<>();
        GameGroupEntity group = groupRepository.findByName(name);
        Iterable<UsergroupEntity> usergroups = usergroupRepository.findAllByIdgroup(group.getIdgroup());
        for(UsergroupEntity u: usergroups) {
            Optional<UserEntity> user = userRepository.findById(u.getIduser());
            users.add(user);
        }
        return users;
    }
}
