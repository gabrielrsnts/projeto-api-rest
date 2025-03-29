package projeto.dio.projeto_api_rest.service.impl;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.User;
import projeto.dio.projeto_api_rest.repository.UserRepository;
import projeto.dio.projeto_api_rest.service.UserService;

import java.util.NoSuchElementException;

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
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User userCreate(User userToCreate) {
        if(userRepository.existsByLogin(userToCreate.getLogin())){
            throw new IllegalArgumentException("Esse Login já existe");
        }
        userToCreate.setPassword(userToCreate.getPassword());
        return userRepository.save(userToCreate);
    }



    @Override
    public boolean authenticate(String login, String rawPassword) {
        User user = userRepository.findByLogin(login).orElse(null);
        if(user != null){
            return user.checkPassword(rawPassword);
        }
        return false;
    }
}
