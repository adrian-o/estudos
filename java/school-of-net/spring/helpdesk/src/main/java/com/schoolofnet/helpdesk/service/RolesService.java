package com.schoolofnet.helpdesk.service;

import java.util.List;

import com.schoolofnet.helpdesk.model.Role;

public interface RolesService {

	public List<Role> findAll();
	public Role create(Role role);
	public Boolean delete(Long id);
	public Role findByName(String name);
}
