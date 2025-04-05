package projeto.dio.projeto_api_rest.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import projeto.dio.projeto_api_rest.domain.model.Categories;

@Entity(name = "tab_item")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String icon;

    @Column(unique = true)
    @NonNull
    private String name;

    private double price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
}
