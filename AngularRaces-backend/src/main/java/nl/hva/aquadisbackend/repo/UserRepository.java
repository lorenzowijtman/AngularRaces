package nl.hva.aquadisbackend.repo;
import nl.hva.aquadisbackend.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//don't forget this one
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    //adds param to the API request
    UserEntity findByEmail(@Param("email") String email);
    UserEntity findByNickname(@Param("nickname") String nickname);
}
