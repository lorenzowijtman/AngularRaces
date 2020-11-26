package nl.hva.aquadisbackend.services;

import nl.hva.aquadisbackend.models.GameGroupEntity;
import nl.hva.aquadisbackend.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {this.groupRepository = groupRepository;}

    public GameGroupEntity createGroup(int id, String name, int admin_id) {
        if(!groupRepository.existsById(id)) {
            return groupRepository.save(new GameGroupEntity(id, name, admin_id));
        } else {
            return null;
        }
    }

    public Iterable<GameGroupEntity> lookup() {
        return groupRepository.findAll();
    }

    public long total() {
        return groupRepository.count();
    }
}
