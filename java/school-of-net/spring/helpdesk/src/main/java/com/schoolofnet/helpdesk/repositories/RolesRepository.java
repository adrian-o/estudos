package com.schoolofnet.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

}
