package fatec.strategy;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.repository.ClienteRepository;
import fatec.repository.JogoRepository;

@Service
public class StrategyUtil {		
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;	
	

	public Map<String, IStrategy> getStrategies() {

		ValidaCliente validaCliente = new ValidaCliente(clienteRepository);
		ValidaJogo validaJogo = new ValidaJogo(jogoRepository);
		ValidaCompra validaCompra = new ValidaCompra(jogoRepository);
		
		Map<String, IStrategy> mapaStrategies = new HashMap<>();
		
		mapaStrategies.put("clienteSalvar", validaCliente);	
		mapaStrategies.put("jogoSalvar", validaJogo);	
		mapaStrategies.put("compraSalvar", validaCompra);
		mapaStrategies.put("clienteAtualizar", validaCliente);	
		mapaStrategies.put("jogoAtualizar", validaJogo);
		mapaStrategies.put("compraAtualizar", validaCompra);
		

		return mapaStrategies;

	}

}
