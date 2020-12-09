package fatec.strategy;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;
import fatec.repository.ClienteRepository;

public class ValidarCliente implements IStrategy {

	private ClienteRepository clienteRepository;	
	
	public ValidarCliente(ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;		
	}
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
			sb.append("Campo nome não pode ser vazio/");
		}			
		Cliente existe = clienteRepository.findByCpf(cliente.getCpf());
		if(existe != null)
		{
			if(cliente.getId() != null) {
				if(existe.getId() != cliente.getId()) {
					sb.append(" CPF ja cadastrado/");
				}
			}
			else {
				sb.append(" CPF ja cadastrado/");
			}			
		}
		if(cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
			sb.append(" Campo CPF não pode ser vazio/");
		}	
		
		if(cliente.getEndereco().getLogradouro() == null || cliente.getEndereco().getLogradouro().trim().isEmpty()) {
			sb.append(" Campo logradouro não pode ser vazio/");
		}
		
		if(cliente.getEndereco().getCep() == null || cliente.getEndereco().getCep().trim().isEmpty()) {
			sb.append(" Campo CEP não pode ser vazio/");
		}
		
		if(cliente.getEndereco().getNumero() == null || cliente.getEndereco().getNumero().trim().isEmpty()) {
			sb.append(" Campo numero não pode ser vazio");
		}
	
		return sb.toString();
	}

}

