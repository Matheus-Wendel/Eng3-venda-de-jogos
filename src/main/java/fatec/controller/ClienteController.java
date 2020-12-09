package fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fatec.command.CommandAtualizar;
import fatec.command.CommandBuscar;
import fatec.command.CommandExcluir;
import fatec.command.CommandSalvar;
import fatec.model.Cliente;
import fatec.model.EntidadeDominio;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private CommandSalvar commandSalvar;
			
	@Autowired
	private CommandBuscar commandBuscar;
	
	@Autowired
	private CommandExcluir commandExcluir;
	
	@Autowired
	private CommandAtualizar commandAtualizar;
	
	
	@GetMapping("/paginaInicioCliente")
	public ModelAndView paginaInicial() {

		ModelAndView mv = new ModelAndView("inicial-cliente");
		mv.addObject("clientes", commandBuscar.execute(new Cliente()));
		return mv;
	}
	

	@PostMapping("/novo")
	public ModelAndView salvarCLiente(Cliente cliente) {
		try {
			commandSalvar.execute(cliente);
			ModelAndView mv = new ModelAndView("redirect:/cliente/paginaInicioCliente");
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ModelAndView mv = new ModelAndView("add-cliente");
			mv.addObject("mensagem", e.getMessage());
			return mv;
		}		
	}
	
	@GetMapping("/paginaCadastro")
	public ModelAndView paginaInicial(Cliente cliente) {

		ModelAndView mv = new ModelAndView("add-cliente");		
		return mv;
	}
	
	@GetMapping("/paginaAtualizar/{id}")
	public ModelAndView paginaAtualizarCliente(@PathVariable("id") Long id) {
		
		ModelAndView mv = new ModelAndView("atualizar-cliente");

		Cliente cliente = new Cliente();
		cliente.setId(id);
		List<? extends EntidadeDominio> listaCliente = commandBuscar.execute(cliente);
		
		mv.addObject("cliente", listaCliente.get(0));

		return mv;
	}

	@PostMapping("/atualizar/{id}")
	public ModelAndView atualizarCliente(@PathVariable("id") long id, Cliente cliente) {
		try {
			cliente.setId(id);
			commandAtualizar.execute(cliente);
			ModelAndView mv = new ModelAndView("redirect:/cliente/paginaInicioCliente");			
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ModelAndView mv = new ModelAndView("atualizar-cliente");
			mv.addObject("mensagem", e.getMessage());
			return mv;
		}
		
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView paginaApagarCliente(@PathVariable("id") long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
	    commandExcluir.execute(cliente);
		
	    ModelAndView mv = new ModelAndView("redirect:/cliente/paginaInicioCliente");
		
		return mv;
	}

}
