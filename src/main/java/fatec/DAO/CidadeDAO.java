package fatec.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.Cidade;
import fatec.model.EntidadeDominio;
import fatec.repository.CidadeRepository;

@Service
public class CidadeDAO implements IDAO {

	@Autowired
	private CidadeRepository repository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Cidade cidade = (Cidade) entidadeDominio;
		return repository.save(cidade);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Cidade cidade = (Cidade) entidadeDominio;
		repository.deleteById(cidade.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return repository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Cidade cidade = (Cidade) entidadeDominio;
		if(repository.existsById(cidade.getId())) {
			return repository.save(cidade);
		}	
		return null;
	}


}
