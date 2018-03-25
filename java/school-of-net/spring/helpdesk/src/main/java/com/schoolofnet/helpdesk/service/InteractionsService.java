package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.Interaction;

public interface InteractionsService {

	public Interaction create(Interaction interaction, Long ticketId);
	public Boolean delete(Long id);

}
