package projeto.dio.projeto_api_rest.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.dio.projeto_api_rest.domain.model.Categories;


@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    boolean existsByName(String name);


}
