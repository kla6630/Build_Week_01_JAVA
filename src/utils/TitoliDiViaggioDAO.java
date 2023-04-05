package utils;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dbconnection.DbConnection;
import modelParcoMezzi.Mezzi;
import modelRivendita.Abbonamento;
import modelRivendita.Biglietto;
import modelRivendita.TitoloDiViaggio;
import modelRivendita.Venditore;

public class TitoliDiViaggioDAO {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	//<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN TITOLO DI VIAGGIO ALLA TABELLA>>>>>>>>>>>>>>>>>>>
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
	
	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
    public static TitoloDiViaggio getById(Long id){
    	try {
  		em.getTransaction().begin();
  		TitoloDiViaggio e = em.find(TitoloDiViaggio.class, id);
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
	
	//<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL PERIODO>>>>>>>>>>>>>>>>>>>
	 public static long contaTitoliDiViaggio(LocalDate startDate, LocalDate endDate) {
	        try {
	            String query = "SELECT COUNT(tv) FROM TitoloDiViaggio tv WHERE tv.dataEmissione BETWEEN :startDate AND :endDate";
	            TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
	            typedQuery.setParameter("startDate", startDate);
	            typedQuery.setParameter("endDate", endDate);
	            System.out.println("il numero dei titoli di viaggio compresi tra la data " + startDate +" e " + endDate + " è: " +  typedQuery.getSingleResult());
	            return typedQuery.getSingleResult();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return 0;
	        }
	    }

	//<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
	    public static long contaBigliettiDaVenditore(LocalDate startDate, LocalDate endDate, Venditore venditore) {
	        try {
	            String query = "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :startDate AND :endDate AND b.venditore = :venditore";
	            TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
	            typedQuery.setParameter("startDate", startDate);
	            typedQuery.setParameter("endDate", endDate);
	            typedQuery.setParameter("venditore", venditore);
	            System.out.println("il numero dei biglietti compresi tra la data " + startDate +" e " + endDate + " dei "+ venditore +" è: " +  typedQuery.getSingleResult());
	            return typedQuery.getSingleResult();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return 0;
	        }
	    }

	  //<<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
	    public static long contaAbbonamentiDaVenditore(LocalDate startDate, LocalDate endDate, Venditore venditore) {
	        try {
	            String query = "SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :startDate AND :endDate AND a.venditore = :venditore";
	            TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
	            typedQuery.setParameter("startDate", startDate);
	            typedQuery.setParameter("endDate", endDate);
	            typedQuery.setParameter("venditore", venditore);
	            System.out.println("il numero degli abbonamenti compresi tra la data " + startDate +" e " + endDate + " dei "+ venditore +" è: " +  typedQuery.getSingleResult());
	            return typedQuery.getSingleResult();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return 0;
	        }
	    }
}
