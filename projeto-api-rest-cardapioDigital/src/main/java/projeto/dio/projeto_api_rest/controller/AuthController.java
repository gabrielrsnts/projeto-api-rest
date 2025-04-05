package projeto.dio.projeto_api_rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.dio.projeto_api_rest.domain.model.User;
import projeto.dio.projeto_api_rest.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.userCreate(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User request) {
        try {
            String token = userService.authenticate(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
        }
    }
}
