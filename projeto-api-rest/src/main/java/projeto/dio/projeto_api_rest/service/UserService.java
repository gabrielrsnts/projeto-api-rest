package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.User;

@Service
public interface UserService {
    User findById(long id);

    User userCreate(User userToCreate);

    boolean authenticate(String login, String rawPassword);
}
