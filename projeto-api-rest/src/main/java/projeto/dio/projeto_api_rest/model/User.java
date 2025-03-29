package projeto.dio.projeto_api_rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Getter
@Setter
@Entity(name = "tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String login;

    @NonNull
    private String password;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Categories> categories;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Item> item;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Order> order;

    // Método para criptografar a senha
    public void setPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    // Método para verificar se a senha é válida
    public boolean checkPassword(String rawPassword) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, this.password);
    }

}
