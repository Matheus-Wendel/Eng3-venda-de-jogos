package fatec.strategy;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.repository.JogoRepository;

@Service
public class StrategyUtil {		
	
	@Autowired
	private JogoRepository jogoRepository;

	public Map<String, IStrategy> getStrategies() {

		ValidaCliente validaCliente = new ValidaCliente();
		ValidaJogo validaJogo = new ValidaJogo(jogoRepository);
		
		Map<String, IStrategy> mapaStrategies = new HashMap<>();
		
		mapaStrategies.put("clienteSalvar", validaCliente);	
		mapaStrategies.put("jogoSalvar", validaJogo);	
		

		return mapaStrategies;

	}

}
