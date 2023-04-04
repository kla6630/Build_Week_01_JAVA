package utils;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelRivendita.Utente;

public class UtenteDAO {
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	public static void save(Utente u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + u.getClass().getSimpleName());
			e.printStackTrace();
		}

	}
}
