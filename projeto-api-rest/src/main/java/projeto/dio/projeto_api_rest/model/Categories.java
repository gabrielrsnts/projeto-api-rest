package projeto.dio.projeto_api_rest.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.support.ManagedArray;

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

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private List<Item> items;



}
