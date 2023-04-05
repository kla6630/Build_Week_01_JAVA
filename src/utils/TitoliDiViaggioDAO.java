package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelParcoMezzi.Mezzi;
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

	// <<<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI
	// VIDIMATI>>>>>>>>>>>>>>>>>>>>>
	public static void vidimaBiglietto(Biglietto bi, LocalDate data, Mezzi mezzo) {
		try {
			em.getTransaction().begin();
			Biglietto b = em.find(Biglietto.class, bi.getId());

			if (b != null) {
				b.vidimaBiglietto(LocalDate.now());
				em.getTransaction().commit();

			} else
				throw new Exception("biglietto non trovato");

		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("erroe vidima biglietto" + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
