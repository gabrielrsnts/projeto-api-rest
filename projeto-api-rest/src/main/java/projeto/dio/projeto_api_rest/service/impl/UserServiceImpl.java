package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.User;
import projeto.dio.projeto_api_rest.repository.UserRepository;
import projeto.dio.projeto_api_rest.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }

    @Override
    public User userCreate(User userToCreate) {
        if (userRepository.existsByLogin(userToCreate.getLogin())) {
            throw new IllegalArgumentException("Esse login já existe");
        }
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        return userRepository.save(userToCreate);
    }

    @Override
    public boolean authenticate(String login, String rawPassword) {
        Optional<User> userOpt = userRepository.findByLogin(login);
        return userOpt.isPresent() && passwordEncoder.matches(rawPassword, userOpt.get().getPassword());
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("Usuário não encontrado");
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
