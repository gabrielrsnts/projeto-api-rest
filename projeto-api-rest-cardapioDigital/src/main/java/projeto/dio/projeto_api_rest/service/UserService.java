package projeto.dio.projeto_api_rest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.User;

import java.util.List;

@Service
public interface UserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User findById(long id);

    User userCreate(User userToCreate);

    String authenticate(String email, String rawPassword);

    User updateUser(Long id, User order);
    void deleteUser(Long id);
    List<User> getAllUser();
}
