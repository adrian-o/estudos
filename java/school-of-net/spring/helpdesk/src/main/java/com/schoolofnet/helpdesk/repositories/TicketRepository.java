package com.schoolofnet.helpdesk.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.schoolofnet.helpdesk.model.Ticket;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

}
