package runnable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import enums.Arrivi;
import enums.DurataAbbonamento;
import gestionemezzi.MezziDiTrasporto;
import enums.Partenze;
import enums.TipoMezzi;
import gestionemezzi.Tratta;
import modelRivendita.Abbonamento;
import modelRivendita.Biglietto;
import modelRivendita.Distributore;
import modelRivendita.RivenditoreFisico;
import modelRivendita.Tessera;
import modelRivendita.TitoloDiViaggio;
import modelRivendita.Utente;
import modelRivendita.Venditore;
import utils.MezziDAO;
import utils.TesseraDAO;
import utils.TitoliDiViaggioDAO;
import utils.UtenteDAO;
import utils.VenditoreDAO;

public class Runnable {
	
	private static final String Runnable = "trasporti_db";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(Runnable);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		
		System.out.println("Buongiorno, benvenuto in Azienda trasporti");

		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE TRATTE >>>>>>>>>>>>>>>>>>>>>>>>>>
//		Tratta como_bologna = new Tratta(Partenze.COMO, Arrivi.BOLOGNA, 2);
//		Tratta como_genova = new Tratta(Partenze.COMO, Arrivi.GENOVA, 3);
//		Tratta como_napoli = new Tratta(Partenze.COMO, Arrivi.NAPOLI, 5);
//		Tratta como_torino = new Tratta(Partenze.COMO, Arrivi.TORINO, 1);
//		Tratta como_venezia = new Tratta(Partenze.COMO, Arrivi.VENEZIA, 4);
//		
//		Tratta firenze_bologna = new Tratta(Partenze.FIRENZE, Arrivi.BOLOGNA, 2);
//		Tratta firenze_genova = new Tratta(Partenze.FIRENZE, Arrivi.GENOVA, 3);
//		Tratta firenze_napoli = new Tratta(Partenze.FIRENZE, Arrivi.NAPOLI, 4);
//		Tratta firenze_torino = new Tratta(Partenze.FIRENZE, Arrivi.TORINO, 2);
//		Tratta firenze_venezia = new Tratta(Partenze.FIRENZE, Arrivi.VENEZIA, 3);
//		
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE MEZZI >>>>>>>>>>>>>>>>>>>>>>>>>>
//		MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna, LocalTime.of(12, 30), 70,false);
//		MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova, LocalTime.of(6, 00), 90, true);
//		MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli, LocalTime.of(10, 30), 130, true);
//		MezziDiTrasporto bus4 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_torino, LocalTime.of(14, 00), 58, true);
//		MezziDiTrasporto bus5 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_venezia, LocalTime.of(17, 30), 70, true);

//		MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_venezia, LocalTime.of(8, 30), 70,true);
//		MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_bologna, LocalTime.of(7, 30), 90,true);
//		MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_genova, LocalTime.of(10, 30), 80,false);
//		MezziDiTrasporto tram4 = new MezziDiTrasporto(TipoMezzi.TRAM,firenze_napoli, LocalTime.of(14, 00), 58,true);
//		MezziDiTrasporto tram5 = new MezziDiTrasporto(TipoMezzi.TRAM,firenze_torino, LocalTime.of(15, 30), 60,true);

		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE RIVENDITE >>>>>>>>>>>>>>>>>>>>>>>>>>
//		 Distributore dist01 = new Distributore(true, "Via dei Suricati 25,Tenerife");
//		 Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
//		
//		 RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
//		 RivenditoreFisico rF02 = new RivenditoreFisico("Via da me 225 MariaTeresaCity");
//		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE BIGLIETTI >>>>>>>>>>>>>>>>>>>>>>>>>>
//		 Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, dist01);
//		 Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false, dist02);
//		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE UTENTI>>>>>>>>>>>>>>>>>>>>>>>>>>
//		 Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(1994, 3, 2));
//		 Utente ut02 = new Utente("Omar", "Covolo", LocalDate.of(2021, 12, 20));
//		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE TESSERA >>>>>>>>>>>>>>>>>>>>>>>>>>
//		 Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), ut01);
//		 Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), ut02);
//		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE ABBONAMENTI >>>>>>>>>>>>>>>>>>>>>>>>>>
//		 Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02, DurataAbbonamento.SETTIMANALE, rF02);
//		 Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01, DurataAbbonamento.MENSILE, rF01);
//		 Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02, DurataAbbonamento.SETTIMANALE, rF02);
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< FINE CREAZIONI >>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< INIZIO SALVATAGGI NEL DATABASE >>>>>>>>>>>>>>>>>>>>>>>>>>
//			gm.insertTratte(como_bologna);
//			gm.insertTratte(como_genova);
//			gm.insertTratte( como_napoli);
//			gm.insertTratte(como_torino);
//			gm.insertTratte(como_venezia);
//			
//			gm.insertTratte(firenze_venezia);
//			gm.insertTratte(firenze_bologna);
//			gm.insertTratte(firenze_genova);
//			gm.insertTratte(firenze_napoli);
//			gm.insertTratte(firenze_torino);

//			gm.insertMezzi(bus1);
//		    gm.insertMezzi(bus2);
//		    gm.insertMezzi(bus3);
//		    gm.insertMezzi(bus4);
//		    gm.insertMezzi(bus5);
//		   
//		    gm.insertMezzi(tram1);
//		    gm.insertMezzi(tram2);
//		    gm.insertMezzi(tram3);
//		    gm.insertMezzi(tram4);
//		    gm.insertMezzi(tram5);
		
//		 UtenteDAO.save(ut01);
//		 UtenteDAO.save(ut02);
//		
//		 TesseraDAO.save(ts01);
//		 TesseraDAO.save(ts02);
//		
//		 VenditoreDAO.save(dist01);
//		 VenditoreDAO.save(dist02);
//		 VenditoreDAO.save(rF01);
//		 VenditoreDAO.save(rF02);
//		
//		 TitoliDiViaggioDAO.save(bg01);
//		 TitoliDiViaggioDAO.save(bg02);
//		 TitoliDiViaggioDAO.save(ab01);
//		 TitoliDiViaggioDAO.save(ab02);
		
//		 MezziDAO.saveTratta(milano_venezia);
//		 MezziDAO.saveTratta(padova_torino);
//		 MezziDAO.saveTratta(firenze_venezia);
//		 MezziDAO.saveTratta(como_bologna);
//		 MezziDAO.saveTratta(como_napoli);
//		 MezziDAO.saveTratta(como_genova);
//		
//		 MezziDAO.save(tram3);
//		 MezziDAO.save(tram2);
//		 MezziDAO.save(tram1);
//		 MezziDAO.save(bus1);
//		 MezziDAO.save(bus2);
//		 MezziDAO.save(bus3);
		// <<<<<<<<<<<<<<<<<<<<<<<<<< FINE SALVATAGGI NEL DATABASE >>>>>>>>>>>>>>>>>>>>>>>>>>
		

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN TITOLODIVIAGGIO PER ID>>>>>>>>>>>>>>>>>>>
	TitoliDiViaggioDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN MEZZO PER ID>>>>>>>>>>>>>>>>>>>
		MezziDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN VENDITORE PER ID>>>>>>>>>>>>>>>>>>>
		Venditore ven1 = VenditoreDAO.getById(1l);
		Venditore ven2 = VenditoreDAO.getById(2l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN UTENTE PER ID>>>>>>>>>>>>>>>>>>>
		UtenteDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UNA TESSERA PER ID>>>>>>>>>>>>>>>>>>>
		Tessera myTessera = TesseraDAO.getById(1l);
		

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL PERIODO>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaTitoliDiViaggio(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20));

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaBigliettiDaVenditore(LocalDate.of(2013, 11, 23), LocalDate.of(2023, 5, 20), ven2);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaAbbonamentiDaVenditore(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20), ven1);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA IL NUMERO DEGLI ABBONAMENTI IN BASE ALL'UTENTE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.numeroAbbonamentiUtente(1L);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE STAMPA GLI ABBONAMENTI IN BASE ALL'UTENTE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.abbonamentiSingoloUtente(1L);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE TRACCIA LE TRATTE>>>>>>>>>>>>>>>>>>>
		MezziDiTrasporto mdz = em.find(MezziDiTrasporto.class, 1L);
		MezziDAO.updateTraccia(mdz);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE VIDIMA I BIGLIETTI>>>>>>>>>>>>>>>>>>>
		Biglietto b01 = em.find(Biglietto.class, 2L);
		TitoliDiViaggioDAO.vidimaBiglietto(b01, LocalDateTime.of(2023, 4, 20, 4, 0), mdz);
	}

}