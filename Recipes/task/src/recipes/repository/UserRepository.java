package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByEmail(String email);

    boolean existsByEmail(String email);
}