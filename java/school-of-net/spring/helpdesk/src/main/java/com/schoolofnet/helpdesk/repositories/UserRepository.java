package com.schoolofnet.helpdesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="select us.* from users us inner join users_roles ur on us.id = ur.user_id where ur.role_id = :role_id", nativeQuery=true)
	public List<User> findAllWhereRoleEquals(@Param("role_id") Long roleId);
}
