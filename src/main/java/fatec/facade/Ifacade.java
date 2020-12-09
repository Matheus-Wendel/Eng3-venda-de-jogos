package fatec.facade;

import java.util.List;

import fatec.model.EntidadeDominio;

public interface Ifacade {
	
	EntidadeDominio save(EntidadeDominio entidade) throws Exception;
	EntidadeDominio delete(EntidadeDominio entidade);
	List<? extends EntidadeDominio> find(EntidadeDominio entidade);
	EntidadeDominio update(EntidadeDominio entidade) throws Exception;
	

}
