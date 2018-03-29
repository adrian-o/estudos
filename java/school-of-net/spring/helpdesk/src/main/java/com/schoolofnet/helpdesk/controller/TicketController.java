package com.schoolofnet.helpdesk.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.model.Interaction;
import com.schoolofnet.helpdesk.model.Role;
import com.schoolofnet.helpdesk.model.Ticket;
import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.service.RolesService;
import com.schoolofnet.helpdesk.service.TicketService;
import com.schoolofnet.helpdesk.service.UserService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService roleService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("ticketList", this.ticketService.findAll());
		model.addAttribute("userLoggedIn", this.userService.findSecurityUser());
		return "tickets/index";
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Ticket ticket = this.ticketService.show(id);
		Set<Interaction> interactions = ticket.getInteractions();
		
		model.addAttribute("ticket", ticket);
		model.addAttribute("interaction", new Interaction());
		model.addAttribute("interactions", interactions);
		model.addAttribute("userLoggedIn", this.userService.findSecurityUser());
		
		return "tickets/show";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());
		this.findAllTechinicians(model);
		return "tickets/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "ticket/create";
		}
		
		this.ticketService.create(ticket);
		
		return "redirect:/tickets";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Ticket ticket = this.ticketService.show(id);
		
		model.addAttribute("ticket", ticket);
		model.addAttribute("interactions_count", ticket.getInteractions().size());
		model.addAttribute("userLoggedIn", this.userService.findSecurityUser());
		
		this.findAllTechinicians(model);
		
		return "tickets/edit";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("ticket") Ticket ticket, 
			BindingResult bingdingResult, Model model) {
		
		if (bingdingResult.hasErrors()) {
			return "tickets/edit";
		}
		
		this.ticketService.update(id, ticket);
		
		return "redirect:/tickets";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		this.ticketService.delete(id);
		return "redirect:/tickets";
	}
	
	private Model findAllTechinicians(Model model) {
		Role adminRole = this.roleService.findByName("ADMIN"); 
		
		User userLogged = this.userService.findSecurityUser();
		
		model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId(), userLogged.getId()));
		
		return model;
	}
	
}