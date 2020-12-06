package fatec.controller;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fatec.command.CommandBuscar;
import fatec.model.Jogo;
import fatec.repository.JogoRepository;

@Controller
public class InicialController {

//	@Autowired
//	CommandBuscar commandBuscar;

	// @GetMapping("/signup")
	// public ModelAndView paginaCadastroUsuario(User user) {
	// ModelAndView mv = new ModelAndView("add-user");

	// mv.addObject("cursos", cursoRepository.findAll());
	// mv.addObject("disciplinas", disciplinaRepository.findAll());
	// mv.addObject("professores", professorRepository.findAll());
	// mv.addObject("turmas", turmaRepository.findAll());
	// return mv;
	// }

	@GetMapping("/")
	public ModelAndView paginaInicial() {

		ModelAndView mv = new ModelAndView("index");		
		return mv;
	}

	
	

	// @PostMapping("/adduser")
	// public ModelAndView salvarUsuario(User user) {

	// userRepository.save(user);

	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/edit/{id}")
	// public ModelAndView paginaAtualizarUsuario(@PathVariable("id") Long id, Model
	// model) {
	// User user = userRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// ModelAndView mv = new ModelAndView("update-user");

	// mv.addObject("cursos", cursoRepository.findAll());
	// mv.addObject("disciplinas", disciplinaRepository.findAll());
	// mv.addObject("professores", professorRepository.findAll());
	// mv.addObject("turmas", turmaRepository.findAll());
	// mv.addObject("user", user);

	// return mv;
	// }

	// @PostMapping("/update/{id}")
	// public ModelAndView atualizarUsuario(@PathVariable("id") long id, User user)
	// {

	// userRepository.save(user);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// mv.addObject("users", userRepository.findAll());
	// return mv;
	// }

	// @GetMapping("/delete/{id}")
	// public String paginaApagarUsuario(@PathVariable("id") long id, Model model) {
	// User user = userRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// userRepository.delete(user);
	// model.addAttribute("users", userRepository.findAll());
	// return "index";
	// }

	// // CADASTRO DE CURSOS
	// @GetMapping("/cadastroCurso")
	// public ModelAndView paginaCadastroCurso(Curso curso) {
	// ModelAndView mv = new ModelAndView("add-curso");
	// return mv;
	// }

	// @PostMapping("/addCurso")
	// public ModelAndView salvarCurso(Curso curso) {

	// cursoRepository.save(curso);

	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/curso/edit/{id}")
	// public ModelAndView paginaAtualizarCurso(@PathVariable("id") Long id) {
	// Curso curso = cursoRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// ModelAndView mv = new ModelAndView("update-curso");
	// mv.addObject("curso", curso);

	// return mv;
	// }

	// @PostMapping("/curso/update/{id}")
	// public ModelAndView atualizarCurso(@PathVariable("id") long id, Curso curso)
	// {

	// cursoRepository.save(curso);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/curso/delete/{id}")
	// public ModelAndView ApagarCurso(@PathVariable("id") long id) {
	// Curso curso = cursoRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// cursoRepository.delete(curso);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// // CADASTRO DE DISCIPLINA
	// @GetMapping("/cadastroDisciplina")
	// public ModelAndView paginaCadastroDisciplina(Disciplina disciplina) {
	// ModelAndView mv = new ModelAndView("add-disciplina");
	// return mv;
	// }

	// @PostMapping("/addDisciplina")
	// public ModelAndView salvarDisciplina(Disciplina disciplina) {

	// disciplinaRepository.save(disciplina);

	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/disciplina/edit/{id}")
	// public ModelAndView paginaAtualizarDisciplina(@PathVariable("id") Long id) {
	// Disciplina disciplina = disciplinaRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// ModelAndView mv = new ModelAndView("update-disciplina");
	// mv.addObject("disciplina", disciplina);

	// return mv;
	// }

	// @PostMapping("/disciplina/update/{id}")
	// public ModelAndView atualizarDisciplina(@PathVariable("id") long id,
	// Disciplina disciplina) {

	// disciplinaRepository.save(disciplina);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/disciplina/delete/{id}")
	// public ModelAndView ApagarDisciplina(@PathVariable("id") long id) {
	// Disciplina disciplina = disciplinaRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// disciplinaRepository.delete(disciplina);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// // CADASTRO DE PROFESSORES
	// @GetMapping("/cadastroProfessor")
	// public ModelAndView paginaCadastroProfessor(Professor professor) {
	// ModelAndView mv = new ModelAndView("add-professor");
	// return mv;
	// }

	// @PostMapping("/addProfessor")
	// public ModelAndView salvarProfessor(Professor professor) {

	// professorRepository.save(professor);

	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/professor/edit/{id}")
	// public ModelAndView paginaAtualizarProfessor(@PathVariable("id") Long id) {
	// Professor professor = professorRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// ModelAndView mv = new ModelAndView("update-professor");
	// mv.addObject("professor", professor);

	// return mv;
	// }

	// @PostMapping("/professor/update/{id}")
	// public ModelAndView atualizarProfessor(@PathVariable("id") long id, Professor
	// professor) {

	// professorRepository.save(professor);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/professor/delete/{id}")
	// public ModelAndView ApagarProfessor(@PathVariable("id") long id) {
	// Professor professor = professorRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// professorRepository.delete(professor);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// // CADASTRO DE TURMAS
	// @GetMapping("/cadastroTurma")
	// public ModelAndView paginaCadastroTurma(Turma turma) {
	// ModelAndView mv = new ModelAndView("add-turma");
	// return mv;
	// }

	// @PostMapping("/addTurma")
	// public ModelAndView salvarTurma(Turma turma) {

	// turmaRepository.save(turma);

	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/turma/edit/{id}")
	// public ModelAndView paginaAtualizarTurma(@PathVariable("id") Long id) {
	// Turma turma = turmaRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// ModelAndView mv = new ModelAndView("update-turma");
	// mv.addObject("turma", turma);

	// return mv;
	// }

	// @PostMapping("/turma/update/{id}")
	// public ModelAndView atualizarTurma(@PathVariable("id") long id, Turma turma)
	// {

	// turmaRepository.save(turma);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }

	// @GetMapping("/turma/delete/{id}")
	// public ModelAndView ApagarTurma(@PathVariable("id") long id) {
	// Turma turma = turmaRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	// turmaRepository.delete(turma);
	// ModelAndView mv = new ModelAndView("redirect:/");

	// return mv;
	// }
}
