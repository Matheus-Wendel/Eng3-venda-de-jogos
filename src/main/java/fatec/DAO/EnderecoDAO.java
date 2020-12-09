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
	private EnderecoRepository enderecorepository;
	
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		return enderecorepository.save(endereco);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		enderecorepository.deleteById(endereco.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return enderecorepository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Endereco endereco = (Endereco) entidadeDominio;
		if(enderecorepository.existsById(endereco.getId())) {
			return enderecorepository.save(endereco);
		}	
		return null;
	}	
	
}
