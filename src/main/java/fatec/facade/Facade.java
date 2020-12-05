package fatec.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.DAO.IDAO;
import fatec.model.EntidadeDominio;
import fatec.strategy.IStrategy;
import fatec.strategy.StrategyUtil;

@Service
public class Facade implements Ifacade {
	
	private Map<String, IDAO> mapaDaos;
	private Map<String, IStrategy> mapaStrategies;
	
	@Autowired
	public Facade(Map<String, IDAO> mapaDaos, StrategyUtil strategyUtil)
	{
		this.mapaDaos = mapaDaos;	
		this.mapaStrategies = strategyUtil.getStrategies();
	}
	
	public IStrategy getStrategy(EntidadeDominio entidade, String metodo)
	{		
		String classe = entidade.getClass().getSimpleName();
		return mapaStrategies.get(classe.toLowerCase() + metodo);
	}
	
	public IDAO getDAO(EntidadeDominio entidade)
	{		
		String classe = entidade.getClass().getSimpleName();
		return mapaDaos.get(classe.toLowerCase() + "DAO");
	}
	
	@Override
	public EntidadeDominio save(EntidadeDominio entidade) {
		IStrategy strategy = getStrategy(entidade, "Salvar");
		String erros = "";
		if(strategy != null)
		{
			erros = strategy.processar(entidade);
		}		
		if(erros.isEmpty())
		{
			IDAO dao = getDAO(entidade);
			return dao.save(entidade) ;
		}
		
		return null;
	}

	@Override
	public EntidadeDominio delete(EntidadeDominio entidade) {
		IStrategy strategy = getStrategy(entidade, "Excluir");
		String erros = "";
		if(strategy != null)
		{
			erros = strategy.processar(entidade);
		}		
		if(erros.isEmpty())
		{
			IDAO dao = getDAO(entidade);
			dao.delete(entidade);
		}
		
		return null;
	}

	@Override
	public List<? extends EntidadeDominio> find(EntidadeDominio entidade) {
		IDAO dao = getDAO(entidade);		
		
		return dao.find(entidade);
	}

	@Override
	public EntidadeDominio update(EntidadeDominio entidade) {
		IStrategy strategy = getStrategy(entidade, "Atualizar");
		String erros = "";
		if(strategy != null)
		{
			erros = strategy.processar(entidade);
		}		
		if(erros.isEmpty())
		{
			IDAO dao = getDAO(entidade);
			return dao.update(entidade) ;
		}
		
		return null;
	}

	
}
