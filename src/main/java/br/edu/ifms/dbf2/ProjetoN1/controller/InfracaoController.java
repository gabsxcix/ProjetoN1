package br.edu.ifms.dbf2.ProjetoN1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN1.model.Infracao;
import br.edu.ifms.dbf2.ProjetoN1.repository.Infracoes;

@Controller
public class InfracaoController{
	
	@Autowired
	private Infracoes infracoes;
	
	@GetMapping("/infracoes")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaInfracoes");
		modelAndView.addObject("infracoes", buscarInfracoes());
		modelAndView.addObject("infracoesBD", infracoes.findAll());
			return modelAndView;
		}
		public List<Infracao> buscarInfracoes() {
			List<Infracao> infracoes = new ArrayList<Infracao>();
			
			Infracao i1 = new Infracao();
			Infracao i2 = new Infracao();
			Infracao i3 = new Infracao();
			
			i1.setId((long) 2);
			i1.setDescricao("Deixar o condutor de usar o cinto segurança");
			i1.setPontos(5);
			i1.setValor(195.23);
			
			i2.setId((long) 3);
			i2.setDescricao("Dirigir veículo segurando/manuseando telefone celular");
			i2.setPontos(7);
			i2.setValor(293.47);
			
			i3.setId((long) 4);
			i3.setDescricao("Estacionar nos acostamentos");
			i3.setPontos(3);
			i3.setValor(88.38);
			
			infracoes.add(i1);
			infracoes.add(i2);
			infracoes.add(i3);
			
			return infracoes;
		}
}