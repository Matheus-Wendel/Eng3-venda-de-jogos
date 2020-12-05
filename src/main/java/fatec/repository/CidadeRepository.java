package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

}
