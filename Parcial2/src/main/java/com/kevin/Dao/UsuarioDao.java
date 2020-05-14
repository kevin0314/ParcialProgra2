package com.kevin.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kevin.entidades.*;;

public class UsuarioDao {
	
public List<Usuariop> validarUsuario(Usuariop usu){
		
		
		List<Usuariop> usuario = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
		
			em.getTransaction().begin();
			usuario = em.createQuery("from Usuariop as u where u.nombre = '"+usu.getNombre()+"' and u.contrasenia='"+usu.getContrasenia()+"' ").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		return usuario;
	}

}
