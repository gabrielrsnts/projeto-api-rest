package projeto.dio.projeto_api_rest.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "tab_item")
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private Categories categories;

    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<Order> orders;


}
