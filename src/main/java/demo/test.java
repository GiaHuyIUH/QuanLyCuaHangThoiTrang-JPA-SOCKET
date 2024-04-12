package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class test {
	public static void main(String[] args) {
		System.out.println("Hello World");
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("jpa-mssql");
		
		try(EntityManager em = emf.createEntityManager()) {
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();	
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
