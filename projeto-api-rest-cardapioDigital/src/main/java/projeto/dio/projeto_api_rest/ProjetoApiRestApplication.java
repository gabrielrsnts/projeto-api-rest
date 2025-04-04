package projeto.dio.projeto_api_rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "API do Cardápio Digital", version = "1.0", description = "Documentação da API")
)
public class ProjetoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApiRestApplication.class, args);
	}

}
