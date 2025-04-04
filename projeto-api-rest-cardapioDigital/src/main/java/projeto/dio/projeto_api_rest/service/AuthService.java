package projeto.dio.projeto_api_rest.service;

import projeto.dio.projeto_api_rest.domain.model.User;

public interface AuthService {
    String authenticate(String email, String password);
}
