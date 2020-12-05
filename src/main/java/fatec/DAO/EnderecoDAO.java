package fatec.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.Endereco;
import fatec.model.EntidadeDominio;
import fatec.repository.EnderecoRepository;

@Service
public class EnderecoDAO implements IDAO {


	@Autowired
	private EnderecoRepository repository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		return repository.save(endereco);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		repository.deleteById(endereco.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return repository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		if(repository.existsById(endereco.getId())) {
			return repository.save(endereco);
		}	
		return null;
	}	
	
}
