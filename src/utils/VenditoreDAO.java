package utils;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelParcoMezzi.Mezzi;
import modelRivendita.Venditore;

public class VenditoreDAO {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	// metodo che salva dentro le tabelle//
	public static void save(Venditore v) {
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + v.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}
	
	
	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
    public static Venditore getById(Long id){
    	try {
  		em.getTransaction().begin();
  		Venditore e = em.find(Venditore.class, id);
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
	
}
