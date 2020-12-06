package fatec.strategy;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;
import fatec.repository.ClienteRepository;

public class ValidaCliente implements IStrategy {

	private ClienteRepository clienteRepository;
	
	public ValidaCliente(ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
			sb.append("Campo nome não pode ser vazio");
		}			
		Cliente existe = clienteRepository.findByCpf(cliente.getCpf());
		if(existe != null)
		{
			sb.append("Cliente com cpf ja cadastrado");
			System.err.println(cliente.getCpf());
		}
		if(cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
			sb.append("Campo CPF não pode ser vazio");
		}	
		
		return sb.toString();
	}
}

