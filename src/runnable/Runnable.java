package runnable;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import enums.Arrivi;
import enums.Partenze;
import enums.TipoMezzi;
import gestionemezzi.MezziDiTrasporto;
import gestionemezzi.Tratta;
import modelRivendita.Biglietto;
import modelRivendita.Distributore;
import modelRivendita.Venditore;
import utils.MezziDAO;
import utils.TesseraDAO;
import utils.TitoliDiViaggioDAO;
import utils.UtenteDAO;
import utils.VenditoreDAO;

public class Runnable {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	public static void main(String[] args) {
		
		
		Tratta como_genova = new Tratta(Partenze.COMO, Arrivi.GENOVA, 2);
		Tratta como_napoli = new Tratta(Partenze.COMO, Arrivi.NAPOLI, 4);
		Tratta como_bologna = new Tratta(Partenze.COMO, Arrivi.BOLOGNA, 2);
		
		
		Tratta firenze_venezia = new Tratta(Partenze.FIRENZE, Arrivi.VENEZIA, 4);
		Tratta padova_torino = new Tratta(Partenze.PADOVA, Arrivi.TORINO, 1);
		Tratta milano_venezia = new Tratta(Partenze.MILANO, Arrivi.VENEZIA, 4);
		
		MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova, LocalTime.of(10, 30), true);
		MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli, LocalTime.of(10, 30), false);
		MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna, LocalTime.of(10, 30), true);
		MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_venezia, LocalTime.of(11, 30), false);
		MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_torino, LocalTime.of(10, 30), true);
		MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_venezia, LocalTime.of(10, 30), false);
		
		
		
//		Distributore dist01 = new Distributore(true, "Via dei Suricati 25, Tenerife");
//		Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
//
//		RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
//		RivenditoreFisico rF02 = new RivenditoreFisico("Via dei Russi 225, Mariupol");
//
//		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, dist01);
//		Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false, dist02);
//
//		Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(1994, 3, 2));
//		Utente ut02 = new Utente("Omar", "Covolo", LocalDate.of(2021, 12, 20));
//		
//		Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), ut01);
//		Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), ut02);
//
//		Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01, DurataAbbonamento.MENSILE, rF01);
//		Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02, DurataAbbonamento.SETTIMANALE, rF02);
//
//		MezziDiTrasporto mz01 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,,LocalDate.of(2022, 12, 20),);
		
//		UtenteDAO.save(ut01);
//		UtenteDAO.save(ut02);
//		
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
		
		
		MezziDAO.saveTratta(milano_venezia);
		MezziDAO.saveTratta(padova_torino);
		MezziDAO.saveTratta(firenze_venezia);
		MezziDAO.saveTratta(como_bologna);
		MezziDAO.saveTratta(como_napoli);
		MezziDAO.saveTratta(como_genova);
		
		
		
		MezziDAO.save(tram3);
		MezziDAO.save(tram2);
		MezziDAO.save(tram1);
		MezziDAO.save(bus1);
		MezziDAO.save(bus2);
		MezziDAO.save(bus3);
		
		
		
		
		
		
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN TITOLODIVIAGGIO PER ID>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.getById(1l);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN MEZZO PER ID>>>>>>>>>>>>>>>>>>>
		MezziDAO.getById(1l);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN VENDITORE PER ID>>>>>>>>>>>>>>>>>>>
		Venditore ven1 =VenditoreDAO.getById(1l);
		Venditore ven2 =VenditoreDAO.getById(2l);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN UTENTE PER ID>>>>>>>>>>>>>>>>>>>
		UtenteDAO.getById(1l);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UNA TESSERA PER ID>>>>>>>>>>>>>>>>>>>
		TesseraDAO.getById(1l);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL PERIODO>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaTitoliDiViaggio(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20));
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaBigliettiDaVenditore(LocalDate.of(2013, 11, 23), LocalDate.of(2023, 5, 20), ven2);
		
		//<<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaAbbonamentiDaVenditore(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20), ven1);
		
		Distributore v = em.find(Distributore.class, 1L);

		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, v);

//		MezziDiTrasporto m = new MezziDiTrasporto();
//
//		MezziDAO.save(m);
//		TitoliDiViaggioDAO.save(bg01);
//
//		TitoliDiViaggioDAO.vidimaBiglietto(bg01, LocalDate.now(), m);
	}

}
