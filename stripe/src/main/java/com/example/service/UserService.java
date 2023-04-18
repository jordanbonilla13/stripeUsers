package com.example.service;

import java.util.Optional;

import com.example.model.User;


public interface UserService {
User createUser(User usuario);
	
Optional<User> showDataUser(long id);

User updateUser(User usuarioActualizado);

void deleteUser(Long id);
}
