package utils;

import java.time.LocalDate;

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
	            String query = "SELECT ab FROM Abbonamento ab inner join Tessere te on te.id=ab.tessera_id where :dataVerifica>te.data_attivazione and :dataVerifica<te.data_scadenza and :dataVerifica>ab.data_emissione and :dataVerifica<ab.datascadenza and te.id=:tessera_iddio";
	        TypedQuery<Abbonamento> typedQuery = em.createQuery(query, Abbonamento.class);
			typedQuery.setParameter("dataVerifica", dataVerifica);
 	        typedQuery.setParameter("tessera_iddio", tessera.getId());
 	        typedQuery.setParameter("abbonamento",ab);
 	        typedQuery.getSingleResult();
 	        
 	  		em.getTransaction().commit();
 	        System.out.println("Il titolo di viaggio in data " + dataVerifica + " è attivo.");
 	    } catch (Exception ex) {
 	        System.out.println("Il titolo di viaggio non è attivo.");
 	        ex.printStackTrace();
 	    }
 	}
 	/*SELECT tv 
 	 * FROM Abbonamento ab
 	 *  inner join Tessere te on te.id=ab.tessera_id 
 	 *  where :dataVerifica>te.data_attivazione 
 	 *  and :dataVerifica<te.data_scadenza 
 	 *  and :dataVerifica>ab.data_emissione 
 	 *  and :dataVerifica<ab.datascadenza 
 	 *  and te.id= :tessera_id
*/
 	
}
