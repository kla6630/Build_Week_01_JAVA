package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

 	public static void verificaValidita(Tessera tessera, Abbonamento ab, LocalDate dataVerifica) {
 	    try {
 	    	em.getTransaction().begin();
	        String query = "SELECT ab FROM Abbonamento ab inner join Tessera te on te.id=ab.tessera where TO_DATE(:dataVerifica,'YYYY-MM-DD') >= te.dataAttivazione and TO_DATE(:dataVerifica,'YYYY-MM-DD') <= te.dataScadenza and   TO_DATE(:dataVerifica,'YYYY-MM-DD') >= ab.dataEmissione and TO_DATE(:dataVerifica,'YYYY-MM-DD') <= ab.dataScadenza and te.id=:tessera_id";
	        TypedQuery<Abbonamento> typedQuery = em.createQuery(query, Abbonamento.class);
			typedQuery.setParameter("dataVerifica", dataVerifica.format(DateTimeFormatter.ISO_DATE));
 	        typedQuery.setParameter("tessera_id", tessera.getId());
 	        //typedQuery.setParameter("abbonamento",ab);
 	        typedQuery.getSingleResult();
 	        
 	  		em.getTransaction().commit();
 	        System.out.println("Il titolo di viaggio in data " + dataVerifica + " è attivo.");
 	    } catch (Exception ex) {
 	        System.out.println("Il titolo di viaggio non è attivo.");
 	        ex.printStackTrace();
 	    }
 	}
 	/* String query = "SELECT ab FROM Abbonamento ab "
	        		+ "inner join Tessera te on te.id=ab.tessera "
	        		+ "where :dataVerifica>te.dataAttivazione and"
	        		+ " :dataVerifica<te.dataScadenza and"
	        		+ " :dataVerifica>ab.dataEmissione and"
	        		+ " :dataVerifica<ab.dataScadenza ";
*/
 	
}
