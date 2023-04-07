package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dbconnection.DbConnection;
import modelRivendita.Abbonamento;
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

	// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
	public static Tessera getById(Long id) {
		try {
			em.getTransaction().begin();
			Tessera e = em.find(Tessera.class, id);
			em.getTransaction().commit();
			System.out.println("la Tessera con id " + id + " e': " + e);
			return e;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di ricerca: ");
			ex.printStackTrace();
			return null;
		}

	}

	public static boolean verificaValidita(Tessera tessera, LocalDate dataVerifica) {
		try {

			String query = "SELECT ab FROM Abbonamento ab inner join Tessera te on te.id=ab.tessera "
					+ "where TO_DATE(:dataVerifica,'YYYY-MM-DD') >= te.dataAttivazione "
					+ "and TO_DATE(:dataVerifica,'YYYY-MM-DD') <= te.dataScadenza "
					+ "and TO_DATE(:dataVerifica,'YYYY-MM-DD') >= ab.dataEmissione "
					+ "and TO_DATE(:dataVerifica,'YYYY-MM-DD') <= ab.dataScadenza and te.id=:tessera_id";
			TypedQuery<Abbonamento> typedQuery = em.createQuery(query, Abbonamento.class);
			typedQuery.setParameter("dataVerifica", dataVerifica.format(DateTimeFormatter.ISO_DATE));
			typedQuery.setParameter("tessera_id", tessera.getId());

			if (typedQuery.getResultList().isEmpty()) {
				return false;
			}

			return true;

		} catch (Exception ex) {
			System.out.println("Errore verifica validità.");
			ex.printStackTrace();
			return false;
		}
	}

// <<<<<<<<<<<<<<<<<<<METODO CHE RINNOVA UNA TESSERA SCADUTA>>>>>>>>>>>>>>>>>>>

	public static void rinnovoTessera(Tessera tessera) {
		if (tessera.getDataScadenza().isBefore(LocalDate.now()) || tessera.getDataScadenza().isEqual(LocalDate.now())) {
			try {
				em.getTransaction().begin();
				Tessera nuovaTessera = new Tessera(LocalDate.now(), tessera.getUtente());
				em.persist(nuovaTessera);
				em.getTransaction().commit();
				System.out.println("Tessera rinnovata");

			} catch (Exception ex) {
				System.out.println("Errore nel rinnovo della tessera");
				ex.printStackTrace();
			}
		} else {
			System.out.println("La tessera è ancora attiva");
		}
	}

}
