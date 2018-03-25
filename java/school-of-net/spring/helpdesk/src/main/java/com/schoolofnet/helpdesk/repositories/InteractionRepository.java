package com.schoolofnet.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.model.Interaction;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

}
