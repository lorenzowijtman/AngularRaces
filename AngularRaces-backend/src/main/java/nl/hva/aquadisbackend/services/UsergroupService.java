package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.UsergroupEntity;
import nl.hva.aquadisbackend.repo.UsergroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsergroupService {
    UsergroupRepository usergroupRepository;

    @Autowired
    public UsergroupService(UsergroupRepository usergroupRepository){this.usergroupRepository = usergroupRepository;}

    public UsergroupEntity createUsergroup(int iduser, int idgroup, byte isAdmin) {
        return usergroupRepository.save(new UsergroupEntity(iduser, idgroup, isAdmin));
    }

    public Iterable<UsergroupEntity> lookup() {return usergroupRepository.findAll();}
    public long total() {return usergroupRepository.count();}
}
