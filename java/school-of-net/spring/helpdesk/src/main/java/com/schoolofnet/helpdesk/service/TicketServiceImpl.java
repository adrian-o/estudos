package com.schoolofnet.helpdesk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.model.Ticket;
import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.repositories.TicketRepository;
import com.schoolofnet.helpdesk.repositories.UserRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Ticket> findAll() {
		return (List<Ticket>)this.repository.findAll();
	}

	@Override
	public Ticket create(Ticket ticket) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userLogged = this.userRepository.findByEmail(auth.getName());
		ticket.setUserOpen(userLogged);
		return this.repository.save(ticket);
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Long id, Ticket ticket) {
		Ticket ticketExists = this.show(id);
		
		if (ticketExists != null) {
			ticketExists.setId(ticket.getId());
			ticketExists.setName(ticket.getName());
			ticketExists.setDescription(ticket.getDescription());
			ticketExists.setFinished(ticket.getFinished());
			ticketExists.setTechnician(ticket.getTechnician());
			
			if (ticket.getFinished()) {
				ticketExists.setClosed(new Date());
			}
			
			this.repository.save(ticketExists);
			
			return true;
		}
		
		return false;
	}

	@Override
	public Ticket show(Long id) {
		return this.repository.findOne(id);
	}

}