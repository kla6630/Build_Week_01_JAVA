package runnable;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import modelParcoMezzi.Autobus;
import modelParcoMezzi.Mezzi;
import modelRivendita.Biglietto;
import modelRivendita.Distributore;
import utils.MezziDAO;
import utils.TitoliDiViaggioDAO;

public class Runnable {
	
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();
	
	public static void main(String[] args) {
		
//		Venditore dist01 = new Distributore(true, "Via dei Suricati 25, Tenerife");
//		Venditore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
//
//		Venditore rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
//		Venditore rF02 = new RivenditoreFisico("Via dei Russi 225, Mariupol");
//
//		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, dist01);
//		Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false, dist02);
//
//		Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(2021, 12, 20));
//
//		Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), ut01);
//		Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), ut01);
//
//		// LocalDate dataEmissione, Tessera tessera, DurataAbbonamento
//		// durataAbbonamento,Venditore venditore
//
//		Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01, DurataAbbonamento.MENSILE, rF01);
//		Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02, DurataAbbonamento.SETTIMANALE, rF02);
//
//		UtenteDAO.save(ut01);
//		TesseraDAO.save(ts01);
//		TesseraDAO.save(ts02);
//
//		VenditoreDAO.save(dist01);
//		VenditoreDAO.save(dist02);
//		VenditoreDAO.save(rF01);
//		VenditoreDAO.save(rF02);
//
//		TitoliDiViaggioDAO.save(bg01);
//		TitoliDiViaggioDAO.save(bg02);
//		TitoliDiViaggioDAO.save(ab01);
//		TitoliDiViaggioDAO.save(ab02);

//		Utente bebo = em.find(Utente.class, 1L);
//
//		Tessera ts021 = new Tessera(LocalDate.of(2022, 12, 20), bebo);
//		TesseraDAO.save(ts021);
		
//		em.getTransaction().begin();
//		Biglietto b = em.find(Biglietto.class, 14L);
//		b.vidimaBiglietto(LocalDate.now());
//		em.getTransaction().commit();

//		Biglietto b = em.find(Biglietto.class, 14L);
		Distributore v = em.find(Distributore.class, 1L);
		
		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, v);
		
		Mezzi m = new Autobus(true, LocalDate.of(2021, 12, 20), null);

		MezziDAO.save(m);
		TitoliDiViaggioDAO.save(bg01);
		
		TitoliDiViaggioDAO.vidimaBiglietto(bg01, LocalDate.now(), m);
	}

}
