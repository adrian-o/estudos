package com.schoolofnet.helpdesk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.model.Interaction;
import com.schoolofnet.helpdesk.model.Ticket;
import com.schoolofnet.helpdesk.repositories.InteractionRepository;
import com.schoolofnet.helpdesk.repositories.TicketRepository;

@Service
public class InteractionServiceImpl implements InteractionsService {
	
	@Autowired
	private InteractionRepository interactionRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Interaction create(Interaction interaction, Long ticketId) {
		Ticket ticket = this.ticketRepository.findOne(ticketId);
		
		interaction.setTicket(ticket);
		interaction.setUserInteraction(userService.findSecurityUser());
		
		return this.interactionRepository.save(interaction);
	}

	@Override
	public Boolean delete(Long id) {	
		Interaction interaction = this.interactionRepository.findOne(id);
		
		if (interaction != null) {
			this.interactionRepository.delete(interaction);
			return true;
		}
		
		return false;
	}
	
}