package fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fatec.command.CommandBuscar;
import fatec.command.CommandSalvar;
import fatec.model.Cliente;
import fatec.model.Compra;
import fatec.model.Jogo;

@RestController
@RequestMapping("/compra")
public class CompraController  {
	
	
	@Autowired
	private CommandSalvar commandSalvar;
			
	@Autowired
	private CommandBuscar commandBuscar;
		
	
	@GetMapping("/paginaInicio")
	public ModelAndView paginaInicialCompra() {

		ModelAndView mv = new ModelAndView("inicial-compra");
		mv.addObject("compras", commandBuscar.execute(new Compra()));
		return mv;
	}
	

	@PostMapping("/novo")
	public ModelAndView salvarCompra(Compra compra) {
		try {
			commandSalvar.execute(compra);
			ModelAndView mv = new ModelAndView("redirect:/compra/paginaInicio");
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ModelAndView mv = new ModelAndView("add-compra");
			mv.addObject("mensagem", e.getMessage());
			mv.addObject("clientes", commandBuscar.execute(new Cliente()));
			mv.addObject("jogos", commandBuscar.execute(new Jogo()));
			return mv;
		}	
		
	}
	
	@GetMapping("/paginaCompra")
	public ModelAndView paginaInicial(Compra compra) {

		ModelAndView mv = new ModelAndView("add-compra");		
		mv.addObject("clientes", commandBuscar.execute(new Cliente()));
		mv.addObject("jogos", commandBuscar.execute(new Jogo()));
		return mv;
	}
	


}
