package com.algaworks.financeiro.util;

import javax.persistence.*;


public class JpaUtil {
	
	private static EntityManagerFactory factory;

	static{
		factory = Persistence.createEntityManagerFactory("FinanceiroPU") ;
	}
	
	public static EntityManager getEntityManager() {
		
		return factory.createEntityManager();
		
	}
	

}
