package com.schoolofnet.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.model.Role;
import com.schoolofnet.helpdesk.model.Ticket;
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
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());
		
		Role adminRole = this.roleService.findByName("ADMIN"); 
		
		model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId()));
		return "tickets/create";
	}
	
}
