package utils;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import gestionemezzi.MezziDiTrasporto;
import modelRivendita.Biglietto;
import modelRivendita.TitoloDiViaggio;


public class MezziDAO {
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	//<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN MEZZO ALLA TABELLA>>>>>>>>>>>>>>>>>>>
	public static void save(MezziDiTrasporto mz) {
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
	
	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
    public static MezziDiTrasporto getById(Long id){
    	try {
  		em.getTransaction().begin();
  		MezziDiTrasporto e = em.find(MezziDiTrasporto.class, id);
  		em.getTransaction().commit();
  		System.out.println(e);
  		return e;
    	} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di ricerca: ");
			ex.printStackTrace();
			return null;
		}
  	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<< MODIFICA MEZZO >>>>>>>>>>>>>>>>>>>>>>>>>>
	 	public static void updateEvento(MezziDiTrasporto mz){
	 			em.getTransaction().begin();
	 			em.merge(mz);
	 			em.getTransaction().commit();
	 			System.out.println("Utente modificato nel database");
	 			System.out.println(mz);
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
	
	
	
	
	
