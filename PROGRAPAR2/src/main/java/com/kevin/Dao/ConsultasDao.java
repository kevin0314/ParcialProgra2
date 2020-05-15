package com.kevin.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kevin.entidades.*;

public class ConsultasDao {
	
	public List<Usuariop> listaConsulta(){
		
		
		List<Usuariop> lista = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("PROGRAPAR2");
		em = emf.createEntityManager();
		
		try {
		
			em.getTransaction().begin();
			lista = em.createQuery("from consultasp").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		return lista;
	}
	
	public void eliminarDatos(Consultasp co) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("PROGRAPAR2");
		em = emf.createEntityManager();

		em.getTransaction().begin();		
		co=em.getReference(Consultasp.class, co.getId());
		em.remove(co);
		em.flush();
		em.getTransaction().commit();
	}
	
	public void actualizarDatos(Consultasp  co) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("PROGRAPAR2");
		em = emf.createEntityManager();
		
		co.getId();
		co.getNombre();
		co.getApellido();

		
		em.getTransaction().begin();
		em.merge(co);
		em.flush();
		em.getTransaction().commit();
		
		
	}

}
