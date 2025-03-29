package projeto.dio.projeto_api_rest.service;

import projeto.dio.projeto_api_rest.model.User;

public interface UserService {
    User findById(long id);

    User userCreate(User userToCreate);

    boolean authenticate(String login, String rawPassword);
}
