package fatec.DAO;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;
import fatec.repository.ClienteRepository;



@Service
public class ClienteDAO implements IDAO {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		return clienteRepository.save(cliente);				
	}
	
	
	@Override
	public void delete(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		clienteRepository.deleteById(cliente.getId());
		
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio) {		
		Cliente cliente = (Cliente) entidadeDominio;
		if(cliente.getId() != null)
		{
			Cliente resultado = clienteRepository.findById(cliente.getId()).get();
			return Arrays.asList(resultado);
		}
		
		return clienteRepository.findAll();		
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidadeDominio) {
		Cliente cliente = (Cliente) entidadeDominio;
		System.err.println(cliente.getId());
		System.err.println(cliente.getNome());
		if(clienteRepository.existsById(cliente.getId())) {
			return clienteRepository.save(cliente);
		}	
		return null;
	}	
	
}