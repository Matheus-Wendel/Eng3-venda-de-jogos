package fatec.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.facade.Facade;
import fatec.model.EntidadeDominio;

@Service
public class CommandSalvar implements ICommand {

	@Autowired
	Facade fachada;

	@Override
	public EntidadeDominio execute(EntidadeDominio entidade) {
		return fachada.save(entidade);
	}

}
