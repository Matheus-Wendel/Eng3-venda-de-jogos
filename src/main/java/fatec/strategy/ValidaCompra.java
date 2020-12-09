package fatec.strategy;

import fatec.model.Jogo;
import fatec.repository.JogoRepository;

import java.util.Date;
import java.util.Optional;

import fatec.model.Compra;
import fatec.model.EntidadeDominio;

public class ValidaCompra implements IStrategy {

	
	private JogoRepository jogoRepository;
	
	public ValidaCompra(JogoRepository jogoRepository)
	{
		this.jogoRepository = jogoRepository;
	}
	
	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Compra compra = (Compra)entidade;
		compra.setDataCompra(new Date());
		Optional<Jogo> opcionalJogo = jogoRepository.findById(compra.getJogo().getId());
		
		if(opcionalJogo.isPresent()) {
			Jogo jogo = opcionalJogo.get();
			compra.setValorTotal(jogo.getValor());
			if(jogo.getDataLancamento().after(new Date())) {
				sb.append("Jogo ainda não lançado");
			}
		}
		else {
			sb.append("Jogo selecionado inválido");
		}
		
		return sb.toString();
	}
}

