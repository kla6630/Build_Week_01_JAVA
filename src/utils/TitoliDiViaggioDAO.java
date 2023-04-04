package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dbconnection.DbConnection;
import modelRivendita.Abbonamento;
import modelRivendita.Biglietto;
import modelRivendita.TitoloDiViaggio;

public class TitoliDiViaggioDAO {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	// metodo che salva dentro le tabelle//
	public static void save(TitoloDiViaggio tv) {
		try {
			em.getTransaction().begin();
			em.persist(tv);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + tv.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}
}
