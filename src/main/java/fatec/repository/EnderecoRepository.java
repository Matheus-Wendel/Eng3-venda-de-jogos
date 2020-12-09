package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import fatec.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

	Endereco findByLogradouro(String logradouro);
}
