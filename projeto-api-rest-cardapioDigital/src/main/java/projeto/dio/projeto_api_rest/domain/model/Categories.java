package projeto.dio.projeto_api_rest.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "tab_categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String icon;

    @Column(unique = true)
    @NonNull
    private String name;
    private String description;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> items = new ArrayList<>();



}
