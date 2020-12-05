package fatec.DAO;

import java.util.List;

import fatec.model.EntidadeDominio;

public interface IDAO {

	public EntidadeDominio save(EntidadeDominio EntidadeDominio);

	public void delete(EntidadeDominio entidadeDominio);
	
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio);
	
	public EntidadeDominio update(EntidadeDominio entidadeDominio);
	

}

