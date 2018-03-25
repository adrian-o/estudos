package com.schoolofnet.helpdesk.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.model.Role;
import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.repositories.RoleRepository;
import com.schoolofnet.helpdesk.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPE;
	
	public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPE) {
		this.repository = repository;
		this.roleRepository = roleRepository;
		this.bCryptPE = bCryptPE;
	}
	
	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User create(User user) {
		user.setPassword(this.bCryptPE.encode(user.getPassword()));
		
		Role userRole = this.roleRepository.findByName("USER");
		
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		return this.repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		User user = findById(id);
		
		if(user != null) {
			this.repository.delete(user);
			return true;
		}
		
		return false;
	}

	@Override
	public User show(Long id) {
		return findById(id);
	}

	@Override
	public Boolean update(Long id, User user) {
		User userExists = findById(id);
		
		if (userExists != null) {
			userExists.setId(user.getId());
			userExists.setName(user.getName());
			userExists.setLastName(user.getLastName());
			userExists.setEmail(user.getEmail());
			userExists.setPassword(this.bCryptPE.encode(user.getPassword()));
			userExists.setActive(user.getActive());
			
			Role userRole = this.roleRepository.findByName(user.getRoles().iterator().next().getName());
			
			userExists.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			
			this.repository.save(userExists);
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public List<User> findAllWhereRoleEquals(Long roleId, Long userId) {
		return this.repository.findAllWhereRoleEquals(roleId, userId);
	}
	
	@Override
	public User findSecurityUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String email = auth.getName();
		
		return this.repository.findByEmail(email);
	}
	
	private User findById(Long id) {
		return this.repository.findOne(id);
	}
}