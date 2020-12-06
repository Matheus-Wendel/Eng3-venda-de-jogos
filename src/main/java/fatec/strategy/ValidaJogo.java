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
		if(jogo.getGenero() == null || jogo.getGenero().trim().isEmpty()) {
			sb.append("Campo gênero não pode ser vazio");
		}	
		if(jogo.getPlataforma() == null || jogo.getPlataforma().trim().isEmpty()) {
			sb.append("Campo plataforma não pode ser vazio");
		}	
		if(jogo.getDescricao() == null  || jogo.getDescricao().trim().isEmpty()) {
			sb.append("Campo descrição não pode ser vazio");
		}	
		return sb.toString();
	}
}

