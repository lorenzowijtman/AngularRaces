package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.UserEntity;
import nl.hva.aquadisbackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(int id, String nickname, String email, String password) {
        if(!userRepository.existsById(id)) {
            return userRepository.save(new UserEntity(id, nickname, password, email));
        } else {
            return null;
        }
    }

    public Iterable<UserEntity> lookup() {
        return userRepository.findAll();
    }

    public long total() {
        return userRepository.count();
    }
}
