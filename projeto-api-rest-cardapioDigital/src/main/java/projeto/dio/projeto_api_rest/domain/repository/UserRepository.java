package projeto.dio.projeto_api_rest.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.dio.projeto_api_rest.domain.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


        boolean existsByEmail(String email);

        Optional<User> findByEmail(String email);

}
