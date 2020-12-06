package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	Cliente findByCpf(String cpf);
}
