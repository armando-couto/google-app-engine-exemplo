package br.com.couto.dao;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private EMFService() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}