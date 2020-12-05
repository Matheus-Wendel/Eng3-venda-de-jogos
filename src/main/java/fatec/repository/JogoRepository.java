package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo,Long> {

	Jogo findByNome(String nome);
}
