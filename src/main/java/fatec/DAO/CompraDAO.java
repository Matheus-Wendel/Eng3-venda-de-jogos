package fatec.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.EntidadeDominio;
import fatec.model.Compra;
import fatec.repository.CompraRepository;

@Service
public class CompraDAO implements IDAO {

	@Autowired
	private CompraRepository repository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Compra compra = (Compra) entidadeDominio;
		return repository.save(compra);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Compra compra = (Compra) entidadeDominio;
		repository.deleteById(compra.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return repository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Compra compra = (Compra) entidadeDominio;
		if(repository.existsById(compra.getId())) {
			return repository.save(compra);
		}	
		return null;
	}
	

}
