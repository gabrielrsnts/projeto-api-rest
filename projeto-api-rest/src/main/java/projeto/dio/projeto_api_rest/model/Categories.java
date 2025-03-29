package projeto.dio.projeto_api_rest.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tab_categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String icon;
    @Column(unique = true)
    private String name;
    private String description;


}
