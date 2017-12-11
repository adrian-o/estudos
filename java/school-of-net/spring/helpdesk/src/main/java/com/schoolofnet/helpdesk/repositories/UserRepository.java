package com.schoolofnet.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
