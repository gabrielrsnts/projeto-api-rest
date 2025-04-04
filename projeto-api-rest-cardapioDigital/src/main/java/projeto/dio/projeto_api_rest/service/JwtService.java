package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String generateToken(String username);
    String extractUsername(String token);
    boolean isTokenValid(String token, String username);
}
