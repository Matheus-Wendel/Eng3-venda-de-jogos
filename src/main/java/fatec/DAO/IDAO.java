package fatec.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import fatec.model.EntidadeDominio;

public interface IDAO {

	public EntidadeDominio save(EntidadeDominio EntidadeDominio);

	public EntidadeDominio delete(EntidadeDominio entidadeDominio);
	
	public List<? extends EntidadeDominio> find(EntidadeDominio entidadeDominio);
	
	public EntidadeDominio update(EntidadeDominio entidadeDominio);
	

}

