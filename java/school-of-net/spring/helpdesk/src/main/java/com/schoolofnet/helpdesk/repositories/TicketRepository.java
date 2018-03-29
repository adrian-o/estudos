package com.schoolofnet.helpdesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.schoolofnet.helpdesk.model.Ticket;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

	@Query(nativeQuery=true, value="select tic.* from tickets as tic where tic.created >= date(now()) - interval (:days) day")
	public List<Ticket> findAllTicketsByDays(@Param("days") Integer days);
}
