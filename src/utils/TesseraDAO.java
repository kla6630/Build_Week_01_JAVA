package utils;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelRivendita.Tessera;

public class TesseraDAO {
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	public static void save(Tessera t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + t.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}
}
