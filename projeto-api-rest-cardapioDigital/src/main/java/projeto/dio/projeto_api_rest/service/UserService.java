package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.User;

import java.util.List;

@Service
public interface UserService {
    User findById(long id);

    User userCreate(User userToCreate);

    boolean authenticate(String login, String rawPassword);

    User updateUser(Long id, User order);
    void deleteUser(Long id);
    List<User> getAllUser();
}
