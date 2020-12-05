package fatec.command;

import fatec.model.EntidadeDominio;

public interface ICommand {

	public Object execute(EntidadeDominio entidade);
}
