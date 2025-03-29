package projeto.dio.projeto_api_rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true)
    private String login;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Categories> categories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> item;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> order;


}
