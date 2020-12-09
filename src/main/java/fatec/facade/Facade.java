package fatec.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.DAO.IDAO;
import fatec.log.Log;
import fatec.log.LogRepository;
import fatec.model.EntidadeDominio;
import fatec.strategy.IStrategy;
import fatec.strategy.StrategyUtil;

@Service
public class Facade implements Ifacade {
	
	private Map<String, IDAO> mapaDaos;
	private Map<String, IStrategy> mapaStrategies;
	private LogRepository logRepository;
	
	@Autowired
	public Facade(Map<String, IDAO> mapaDaos, StrategyUtil strategyUtil, LogRepository logRepository)
	{
		this.mapaDaos = mapaDaos;	
		this.mapaStrategies = strategyUtil.getStrategies();
		this.logRepository = logRepository;
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
	public EntidadeDominio save(EntidadeDominio entidade) throws Exception {
		IStrategy strategy = getStrategy(entidade, "Salvar");
		String erros = "";
		if(strategy != null)
		{
			erros = strategy.processar(entidade);
		}		
		if(erros.isEmpty())
		{
			IDAO dao = getDAO(entidade);
			EntidadeDominio entidadeSalva = dao.save(entidade);
			gerarLog(entidadeSalva, "Salvar");
			return entidadeSalva;
		}
		
		throw new Exception(erros);		
		
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
			gerarLog(entidade, "Excluir");
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
			EntidadeDominio entidadeAtualizada = dao.save(entidade);
			gerarLog(entidadeAtualizada, "Atualizar");
			return entidadeAtualizada;
		}
		
		return null;
	}

	public void gerarLog(EntidadeDominio entidade, String metodo) {
		Log log = new Log();
		log.setIdAlterado(entidade.getId());
		log.setMetodo(metodo);
		log.setNomeTabela(entidade.getClass().getSimpleName());
		log.setData(new Date());
		logRepository.save(log);
	}
	
}
