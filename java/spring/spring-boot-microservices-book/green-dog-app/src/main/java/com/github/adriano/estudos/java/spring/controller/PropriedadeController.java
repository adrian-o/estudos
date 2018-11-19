package com.github.adriano.estudos.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.adriano.estudos.java.spring.model.entity.Propriedade;
import com.github.adriano.estudos.java.spring.model.repository.PropriedadeRepository;

@RestController 
@RequestMapping("/api") 
public	class	PropriedadeController	{

	@Autowired 
	private	PropriedadeRepository repository;
	
	@RequestMapping(value="/find/{filtro}", method=RequestMethod.GET) 
	List<Propriedade> findByFiltro(@PathVariable("filtro")	String	filtro)	{				
		return	repository.findByFiltro(filtro); 
	}
	
}