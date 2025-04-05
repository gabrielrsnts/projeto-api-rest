package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.controller.exception.UserNotFoundException;
import projeto.dio.projeto_api_rest.domain.model.User;
import projeto.dio.projeto_api_rest.domain.repository.UserRepository;
import projeto.dio.projeto_api_rest.service.JwtService;
import projeto.dio.projeto_api_rest.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não encontrado"));
    }

    @Override
    public User userCreate(User userToCreate) {
        if (userRepository.existsByEmail(userToCreate.getEmail())) {
            throw new IllegalArgumentException("Esse email já existe");
        }
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        return userRepository.save(userToCreate);
    }

    @Override
    public String authenticate(String email, String rawPassword) {
        try {
            UserDetails user = userDetailsService.loadUserByUsername(email);
            if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
                throw new BadCredentialsException("Senha incorreta");
            }
            return jwtService.generateToken(user.getUsername());
        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Usuário não encontrado");
        }
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
