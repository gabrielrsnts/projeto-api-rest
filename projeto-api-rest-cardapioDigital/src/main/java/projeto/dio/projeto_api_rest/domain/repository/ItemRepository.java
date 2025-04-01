package projeto.dio.projeto_api_rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.dio.projeto_api_rest.domain.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByName(String name);


}
