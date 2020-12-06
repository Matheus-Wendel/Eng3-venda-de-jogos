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
import fatec.model.EntidadeDominio;
import fatec.model.Jogo;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	private CommandSalvar commandSalvar;
			
	@Autowired
	private CommandBuscar commandBuscar;
	
	@Autowired
	private CommandExcluir commandExcluir;
	
	@Autowired
	private CommandAtualizar commandAtualizar;
	
	
	@GetMapping("/paginaInicioJogo")
	public ModelAndView paginaInicial() {

		ModelAndView mv = new ModelAndView("inicial-jogo");
		mv.addObject("jogos", commandBuscar.execute(new Jogo()));
		return mv;
	}
	

	@PostMapping("/novo")
	public ModelAndView salvarJogo(Jogo jogo) {
		commandSalvar.execute(jogo);
		ModelAndView mv = new ModelAndView("redirect:/jogo/paginaInicioJogo");
		return mv;
	}
	
	@GetMapping("/paginaCadastro")
	public ModelAndView paginaInicial(Jogo jogo) {

		ModelAndView mv = new ModelAndView("add-jogo");		
		return mv;
	}
	
	@GetMapping("/paginaAtualizar/{id}")
	public ModelAndView paginaAtualizarJogo(@PathVariable("id") Long id) {
		
		ModelAndView mv = new ModelAndView("atualizar-jogo");

		Jogo jogo = new Jogo();
		jogo.setId(id);
		List<? extends EntidadeDominio> listaJogo = commandBuscar.execute(jogo);
		
		mv.addObject("jogo", listaJogo.get(0));

		return mv;
	}

	@PostMapping("/atualizar/{id}")
	public ModelAndView atualizarJogo(@PathVariable("id") long id, Jogo jogo) {
		jogo.setId(id);
		commandAtualizar.execute(jogo);
		ModelAndView mv = new ModelAndView("redirect:/jogo/paginaInicioJogo");
		
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView paginaApagarJogo(@PathVariable("id") long id) {
		Jogo jogo = new Jogo();
		jogo.setId(id);
	    commandExcluir.execute(jogo);
		
	    ModelAndView mv = new ModelAndView("redirect:/jogo/paginaInicioJogo");
		
		return mv;
	}
}
