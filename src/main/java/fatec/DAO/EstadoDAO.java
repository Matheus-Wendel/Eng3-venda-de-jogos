package fatec.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.Estado;
import fatec.model.EntidadeDominio;
import fatec.repository.EstadoRepository;

@Service
public class EstadoDAO implements IDAO {


	@Autowired
	private EstadoRepository repository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Estado estado = (Estado) entidadeDominio;
		return repository.save(estado);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Estado estado = (Estado) entidadeDominio;
		repository.deleteById(estado.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return repository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Estado estado = (Estado) entidadeDominio;
		if(repository.existsById(estado.getId())) {
			return repository.save(estado);
		}	
		return null;
	}	
	
}
