package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.mitocode.model.UserData;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IUserRepo;
import com.mitocode.service.IUserService;

public class UserServiceImpl extends CRUDImpl<UserData, Integer> implements IUserService {
	
	@Autowired
	private IUserRepo repo;

	@Override
	protected IGenericRepo<UserData, Integer> getRepo() {
		return repo;
	}
}
