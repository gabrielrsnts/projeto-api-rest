package projeto.dio.projeto_api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.dio.projeto_api_rest.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


        boolean existsByLogin(String login);

        Optional<User> findByLogin(String login);
}
