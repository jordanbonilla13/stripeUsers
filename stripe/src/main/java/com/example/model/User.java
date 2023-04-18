package com.example.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="usuarios")
public class User {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(length=100)
		private Long id;
		
		@Column(length=50, nullable=false)
		private String nombre;
		
		@Column(length=75, nullable=false)
		private String apellidos;
		
		
		@Column(length=50, nullable=false)
		private String correo;
		
		@Column(length=50, nullable=false)
		private String telefono;
		
		
		public User(Long id, String nom, String ap, String correo, String telf) {
			this.id = id;
			this.nombre = nom;
			this.apellidos = ap;
			this.correo = correo;
			this.telefono = telf;
			
		}
		
		public User() {}

		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		

		
		
	}
