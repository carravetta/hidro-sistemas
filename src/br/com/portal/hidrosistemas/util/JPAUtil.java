package br.com.portal.hidrosistemas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("portalhidro");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
