package com.mitocode.service.impl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mitocode.model.Role;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IRolRepo;
import com.mitocode.service.IRoleService;

@Service
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {
	
	@Autowired
	private IRolRepo repo;

	@Override
	protected IGenericRepo<Role, Integer> getRepo() {
		return repo;
	}
		

}
