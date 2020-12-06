package fatec.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.facade.Facade;
import fatec.model.EntidadeDominio;
@Service
public class CommandBuscar implements ICommand {

	@Autowired
	Facade fachada;

	@Override
	public List<? extends EntidadeDominio>  execute(EntidadeDominio entidade) {

		return fachada.find(entidade);

	}

}
