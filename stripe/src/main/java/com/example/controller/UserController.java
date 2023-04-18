package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService servicioUsuario;
		
	@PostMapping("/newUser")
	public User crearUsuario(@RequestBody User u) {
		User usu = servicioUsuario.createUser(u);
		return usu;
	}
		
	@GetMapping("/{id}")
	public Optional<User> mostrarUsuario(@PathVariable("id") Long id) {
		return servicioUsuario.showDataUser(id);
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<User> actualizarUsuario(@PathVariable("id") Long id,@RequestBody User usu) {
		Optional<User> u = servicioUsuario.showDataUser(id);		
		User newUser = u.get();

		if(usu.getNombre().equals("")) {
			newUser.setNombre(newUser.getNombre());
		}else {
			newUser.setNombre(usu.getNombre());
		}
		if(usu.getApellidos().equals("")) {
			newUser.setApellidos(newUser.getApellidos());
		}else {
			newUser.setApellidos(usu.getApellidos());
		}
		if(usu.getCorreo().equals("")) {
			newUser.setCorreo(newUser.getCorreo());
		}else {
			newUser.setCorreo(newUser.getCorreo());
		}
		if(usu.getTelefono().equals("")) {
			newUser.setTelefono(newUser.getTelefono());
		}else {
			newUser.setTelefono(usu.getTelefono());
		}
	     servicioUsuario.updateUser(newUser);

	     return ResponseEntity.ok(newUser);
   }
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> eliminarUsuario(@PathVariable("id") Long id){
		Optional<User> p = servicioUsuario.showDataUser(id);		
		User deleteUser = p.get();
			
		try {
				
			servicioUsuario.deleteUser(deleteUser.getId());
				
			return new ResponseEntity<>(id, HttpStatus.OK);
				
		} catch (Exception e) {
				
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
						 
		}
	

}
