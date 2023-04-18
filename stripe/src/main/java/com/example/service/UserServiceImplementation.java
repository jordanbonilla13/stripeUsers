package com.example.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.model.User;
import com.example.repository.repositoryUser;

@Service
public class UserServiceImplementation implements UserService{
	
	private final repositoryUser repoUser;
	
	public UserServiceImplementation(repositoryUser rUs) {
		super();
		this.repoUser = rUs;
	}

	@Override
	public User createUser(User usuario) {
		return repoUser.save(usuario);
		
	}

	@Override
	public Optional<User> showDataUser(long id) {
		return repoUser.findById(id);
	}

	@Override
	public User updateUser(User userUpdated) {
		return repoUser.save(userUpdated);
	}

	@Override
	public void deleteUser(Long id) {
		repoUser.deleteById(id);
		
	}

}
