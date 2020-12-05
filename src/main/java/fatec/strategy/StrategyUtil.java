package fatec.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyUtil {

	@Autowired
	ValidaCliente validaCliente;
	

	public Map<String, List<IStrategy>> getStrategies() {

		List<IStrategy> validaCliente = new ArrayList<>();
		

		validaCliente.add((IStrategy) validaCliente);
		
		Map<String, List<IStrategy>> mapaStrategies = new HashMap<>();
		mapaStrategies.put("cliente", validaCliente);
		

		return mapaStrategies;

	}

}
