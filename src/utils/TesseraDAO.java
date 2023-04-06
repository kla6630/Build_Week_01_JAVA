package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dbconnection.DbConnection;
import modelRivendita.Abbonamento;
import modelRivendita.Tessera;
import modelRivendita.TitoloDiViaggio;

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
	
	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
    public static Tessera getById(Long id){
    	try {
  		em.getTransaction().begin();
  		Tessera e = em.find(Tessera.class, id);
  		em.getTransaction().commit();
  		System.out.println(e);
  		return e;
    	} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di ricerca: ");
			ex.printStackTrace();
			return null;}
		
  	}

 	public static void verificaValidita(Tessera tessera, TitoloDiViaggio titolo, LocalDate dataVerifica) {
 	    try {
	            String query = "SELECT tv FROM TitoloDiViaggio tv WHERE :dataverifica BETWEEN tv.dataEmissione AND tv.dataScadenza AND :dataVerifica BETWEEN tessera.dataAttivazione AND tessera.dataScadenza";
 	        TypedQuery<TitoloDiViaggio> typedQuery = em.createQuery(query, TitoloDiViaggio.class);
 	        typedQuery.setParameter("dataVerifica", dataVerifica);
 	        typedQuery.setParameter("tessera", tessera);
 	        typedQuery.setParameter("titolo", titolo);
 	        TitoloDiViaggio titoloVerificato = typedQuery.getSingleResult();
 	        System.out.println("Il titolo di viaggio in data " + dataVerifica + " è attivo.");
 	    } catch (Exception ex) {
 	        System.out.println("Il titolo di viaggio non è attivo.");
 	        ex.printStackTrace();
 	    }
 	}

}
