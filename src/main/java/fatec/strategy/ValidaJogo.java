package fatec.strategy;

import fatec.model.Jogo;
import fatec.repository.JogoRepository;
import fatec.model.EntidadeDominio;

public class ValidaJogo implements IStrategy {

	
	private JogoRepository jogoRepository;
	
	public ValidaJogo(JogoRepository jogoRepository)
	{
		this.jogoRepository = jogoRepository;
	}
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Jogo jogo = (Jogo) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(jogo.getNome() == null || jogo.getNome().trim().isEmpty()) {
			sb.append("Campo nome não pode ser vazio");
		}			
		Jogo existe = jogoRepository.findByNome(jogo.getNome());
		if(existe != null)
		{
			sb.append("Jogo com nome ja cadastrado");
			System.err.println(jogo.getNome());
		}
		return sb.toString();
	}
}

