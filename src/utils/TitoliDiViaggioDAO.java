package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dbconnection.DbConnection;
import gestionemezzi.MezziDiTrasporto;
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
	
	public static void vidimaBiglietto(Biglietto bi, LocalDateTime data, MezziDiTrasporto mezzo) {
		try {
			em.getTransaction().begin();
			Biglietto b = em.find(Biglietto.class, bi.getId());

			if (b != null) {
				b.vidimaBiglietto(data, mezzo);
				em.getTransaction().commit();
				System.out.println("biglietto vidimato");
			} else
				throw new Exception("biglietto non trovato");

		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("errore vidima biglietto" + ex.getMessage());
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

		// giorno specifico
		public static long contaBigliettiVidimati(LocalDateTime giorno, MezziDiTrasporto mezzo) {
			try {
				String query = "SELECT COUNT(b) FROM Biglietto b INNER JOIN MezziDiTrasporto m ON b.mezzo = m.id WHERE b.vidimato = true AND m.id=:idMezzo AND b.dataOraVidimazione =:data ";
				TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
				typedQuery.setParameter("idMezzo", mezzo.getId());
				typedQuery.setParameter("data", giorno);
				System.out.println("il numero dei biglietti vidimati in data " + giorno + " sul mezzo  " + mezzo
						+ " è: " + typedQuery.getSingleResult());
				return typedQuery.getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}

		}

		// intervallo di date
		public static long contaBigliettiVidimati(LocalDateTime startDate, LocalDateTime endDate,
				MezziDiTrasporto mezzo) {
			try {
				String query = "SELECT COUNT(b) FROM Biglietto b INNER JOIN MezziDiTrasporto m ON b.mezzo = m.id "
						+ "WHERE b.vidimato = true AND m.id=:idMezzo AND b.dataOraVidimazione BETWEEN :startDate AND :endDate";
				TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
				typedQuery.setParameter("idMezzo", mezzo.getId());
				typedQuery.setParameter("startDate", startDate);
				typedQuery.setParameter("endDate", endDate);
				System.out.println("il numero dei biglietti vidimati tra la data " + startDate + " e " + endDate
						+ " sul mezzo  " + mezzo
						+ " è: " + typedQuery.getSingleResult());
				return typedQuery.getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			
		}
}
