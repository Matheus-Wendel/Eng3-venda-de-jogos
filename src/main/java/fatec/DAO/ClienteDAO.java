package fatec.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;
import fatec.repository.ClienteRepository;

@Service
public class ClienteDAO implements IDAO {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		return repository.save(cliente);				
	}

	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		repository.deleteById(cliente.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		return repository.findAll();
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		if(repository.existsById(cliente.getId())) {
			return repository.save(cliente);
		}	
		return null;
	}	
	
	
}