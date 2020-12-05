package fatec.strategy;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;

public class ValidaCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(cliente.getNome().trim().isEmpty()) {
			sb.append("Campo nome não pode ser vazio");
		}
		if(cliente.getCpf().trim().isEmpty()) {
			sb.append("Campo CPF não pode ser vazio");
		}		
		return sb.toString();
	}
}

