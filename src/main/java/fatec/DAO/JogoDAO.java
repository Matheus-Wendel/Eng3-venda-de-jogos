package fatec.DAO;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.EntidadeDominio;
import fatec.model.Jogo;
import fatec.repository.JogoRepository;

@Service
public class JogoDAO implements IDAO {

	@Autowired
	private JogoRepository jogoRepository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Jogo jogo = (Jogo) entidadeDominio;
		return jogoRepository.save(jogo);				
	}
	
	
	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Jogo jogo = (Jogo) entidadeDominio;
		jogoRepository.deleteById(jogo.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		Jogo jogo = (Jogo) entidadeDominio;
		if(jogo.getId() != null)
		{
			Jogo resultado = jogoRepository.findById(jogo.getId()).get();
			return Arrays.asList(resultado);
		}
		return jogoRepository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Jogo jogo = (Jogo) entidadeDominio;
		System.err.println(jogo.getId());
		System.err.println(jogo.getNome());
		if(jogoRepository.existsById(jogo.getId())) {
			return jogoRepository.save(jogo);
		}	
		return null;
	}

}
