package utils;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelParcoMezzi.Mezzi;
import modelRivendita.Biglietto;


public class MezziDAO {
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	// metodo che salva dentro le tabelle//
	public static void save(Mezzi mz) {
		try {
			em.getTransaction().begin();
			em.persist(mz);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + mz.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}
	
	//<<<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI VIDIMATI>>>>>>>>>>>>>>>>>>>>>
	public static void vidimaBiglietto(Biglietto bi) {
		Integer numVidimati=0;
		
		if(bi.getVidimato()) {
			numVidimati+=1;
			bi.setVidimato(true);
		}
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
