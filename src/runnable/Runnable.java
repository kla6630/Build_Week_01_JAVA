package runnable;

//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import javax.persistence.EntityManager;
//
//import dbconnection.DbConnection;
//import enums.Arrivi;
//import enums.DurataAbbonamento;
//import enums.Partenze;
//import enums.TipoMezzi;
//import gestionemezzi.MezziDiTrasporto;
//import gestionemezzi.Tratta;
//import modelRivendita.Abbonamento;
//import modelRivendita.Biglietto;
//import modelRivendita.Distributore;
//import modelRivendita.RivenditoreFisico;
//import modelRivendita.Tessera;
//import modelRivendita.TitoloDiViaggio;
//import modelRivendita.Utente;
//import modelRivendita.Venditore;
//import utils.MezziDAO;
//import utils.TesseraDAO;
//import utils.TitoliDiViaggioDAO;
//import utils.UtenteDAO;
//import utils.VenditoreDAO;
//
//public class Runnable {
//
//	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();
//
//	public static void main(String[] args) {
//
//		//
//		  Tratta como_genova = new Tratta(Partenze.COMO, Arrivi.GENOVA, 2l);
//		 Tratta como_napoli = new Tratta(Partenze.COMO, Arrivi.NAPOLI, 4l);
//		 Tratta como_bologna = new Tratta(Partenze.COMO, Arrivi.BOLOGNA, 2l);
//		//
//		//
//		 Tratta firenze_venezia = new Tratta(Partenze.FIRENZE, Arrivi.VENEZIA, 4l);
//		 Tratta padova_torino = new Tratta(Partenze.PADOVA, Arrivi.TORINO, 1l);
//		 Tratta milano_venezia = new Tratta(Partenze.MILANO, Arrivi.VENEZIA, 4l);
//		//
//		 MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova,LocalTime.of(10, 30), true);
//		 MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli,LocalTime.of(10, 30), false);
//		MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna,LocalTime.of(10, 30), true);
//		 MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,firenze_venezia, LocalTime.of(11, 30), false);
//		 MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,padova_torino, LocalTime.of(10, 30), true);
//		 MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,milano_venezia, LocalTime.of(10, 30), false);
//		//
//		//
//		//
//		 Distributore dist01 = new Distributore(true, "Via dei Suricati 25,Tenerife");
//		 Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
//		//
//		 RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
//		 RivenditoreFisico rF02 = new RivenditoreFisico("Via dei Russi 225,Mariupol");
//		//
//		 Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, dist01);
//		 Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false, dist02);
//		//
//		 Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(1994, 3, 2));
//		 Utente ut02 = new Utente("Omar", "Covolo", LocalDate.of(2021, 12, 20));
//		//
//		 Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), ut01);
//		 Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), ut02);
//		 
//		
//		 Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01,
//		 DurataAbbonamento.MENSILE, rF01);
//	     Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02,
//		 DurataAbbonamento.SETTIMANALE, rF02);
//		//
//		//
//		/* UtenteDAO.save(ut01);
//		 UtenteDAO.save(ut02);
//		//
//		 TesseraDAO.save(ts01);
//		 TesseraDAO.save(ts02);
//		//
//		 VenditoreDAO.save(dist01);
//		 VenditoreDAO.save(dist02);
//		 VenditoreDAO.save(rF01);
//		 VenditoreDAO.save(rF02);
//		//
//		 TitoliDiViaggioDAO.save(bg01);
//		 TitoliDiViaggioDAO.save(bg02);
//		 TitoliDiViaggioDAO.save(ab01);
//		TitoliDiViaggioDAO.save(ab02);
//		//
//		 MezziDAO.saveTratta(milano_venezia);
//		 MezziDAO.saveTratta(padova_torino);
//		 MezziDAO.saveTratta(firenze_venezia);
//		 MezziDAO.saveTratta(como_bologna);
//		 MezziDAO.saveTratta(como_napoli);
//		 MezziDAO.saveTratta(como_genova);
//		//
//		 MezziDAO.save(tram3);
//		 MezziDAO.save(tram2);
//		 MezziDAO.save(tram1);
//		 MezziDAO.save(bus1);
//		 MezziDAO.save(bus2);
//		 MezziDAO.save(bus3);*/
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN TITOLODIVIAGGIO PER
//		// ID>>>>>>>>>>>>>>>>>>>
//		TitoliDiViaggioDAO.getById(1l);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN MEZZO PER ID>>>>>>>>>>>>>>>>>>>
//		MezziDAO.getById(1l);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN VENDITORE PER ID>>>>>>>>>>>>>>>>>>>
//		Venditore ven1 = VenditoreDAO.getById(1l);
//		Venditore ven2 = VenditoreDAO.getById(2l);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN UTENTE PER ID>>>>>>>>>>>>>>>>>>>
//		UtenteDAO.getById(1l);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UNA TESSERA PER ID>>>>>>>>>>>>>>>>>>>
//		Tessera myTessera = TesseraDAO.getById(1l);
//		TitoloDiViaggio myTv= TitoliDiViaggioDAO.getById(7l);
//		Abbonamento b = em.find(Abbonamento.class, 8L);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL
//		// PERIODO>>>>>>>>>>>>>>>>>>>
//		TitoliDiViaggioDAO.contaTitoliDiViaggio(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20));
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL
//		// VENDITORE>>>>>>>>>>>>>>>>>>>
//		TitoliDiViaggioDAO.contaBigliettiDaVenditore(LocalDate.of(2013, 11, 23), LocalDate.of(2023, 5, 20), ven2);
//
//		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL
//		// VENDITORE>>>>>>>>>>>>>>>>>>>
//		TitoliDiViaggioDAO.contaAbbonamentiDaVenditore(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20), ven1);
//
//		Distributore v = em.find(Distributore.class, 1L);
//
//		//Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, v);
//
//		// MezziDiTrasporto m = new MezziDiTrasporto();
//		//
//		// MezziDAO.save(m);
//		// TitoliDiViaggioDAO.save(bg01);
//		//
//		// TitoliDiViaggioDAO.vidimaBiglietto(bg01, LocalDate.now(), m);
//
//		//MezziDAO.selectTratta(1);
//		System.out.println(myTessera);
//		System.out.println(b);
//		
//		TesseraDAO.verificaValidita(myTessera, b, LocalDate.of(2022, 12, 22));
//
//	}
//
//}

import java.time.LocalTime;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import enums.Arrivi;
import gestionemezzi.MezziDiTrasporto;
import enums.Partenze;
import enums.TipoMezzi;
import gestionemezzi.Tratta;
import utils.MezziDAO;

public class Runnable {
	
	private static final String Runnable = "trasporti_db";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(Runnable);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {

		Tratta como_bologna = new Tratta(Partenze.COMO, Arrivi.BOLOGNA, 2);
		Tratta como_genova = new Tratta(Partenze.COMO, Arrivi.GENOVA, 3);
		Tratta como_napoli = new Tratta(Partenze.COMO, Arrivi.NAPOLI, 5);
		Tratta como_torino = new Tratta(Partenze.COMO, Arrivi.TORINO, 1);
		Tratta como_venezia = new Tratta(Partenze.COMO, Arrivi.VENEZIA, 4);
		
		Tratta firenze_bologna = new Tratta(Partenze.FIRENZE, Arrivi.BOLOGNA, 2);
		Tratta firenze_genova = new Tratta(Partenze.FIRENZE, Arrivi.GENOVA, 3);
		Tratta firenze_napoli = new Tratta(Partenze.FIRENZE, Arrivi.NAPOLI, 4);
		Tratta firenze_torino = new Tratta(Partenze.FIRENZE, Arrivi.TORINO, 2);
		Tratta firenze_venezia = new Tratta(Partenze.FIRENZE, Arrivi.VENEZIA, 3);
		
		Tratta milano_bologna = new Tratta(Partenze.MILANO, Arrivi.BOLOGNA, 3);
		Tratta milano_genova = new Tratta(Partenze.MILANO, Arrivi.GENOVA, 3);
		Tratta milano_napoli = new Tratta(Partenze.MILANO, Arrivi.NAPOLI, 6);
		Tratta milano_torino = new Tratta(Partenze.MILANO, Arrivi.TORINO, 1);
		Tratta milano_venezia = new Tratta(Partenze.MILANO, Arrivi.VENEZIA, 2);
		
		Tratta padova_bologna = new Tratta(Partenze.PADOVA, Arrivi.BOLOGNA, 2);
		Tratta padova_genova = new Tratta(Partenze.PADOVA, Arrivi.GENOVA, 4);
		Tratta padova_napoli = new Tratta(Partenze.PADOVA, Arrivi.NAPOLI, 5);
		Tratta padova_torino = new Tratta(Partenze.PADOVA, Arrivi.TORINO, 4);
		Tratta padova_venezia = new Tratta(Partenze.PADOVA, Arrivi.VENEZIA, 1);
		
		Tratta roma_bologna = new Tratta(Partenze.ROMA, Arrivi.BOLOGNA, 3);
		Tratta roma_genova = new Tratta(Partenze.ROMA, Arrivi.GENOVA, 3);
		Tratta roma_napoli = new Tratta(Partenze.ROMA, Arrivi.NAPOLI, 2);
		Tratta roma_torino = new Tratta(Partenze.ROMA, Arrivi.TORINO, 5);
		Tratta roma_venezia = new Tratta(Partenze.ROMA, Arrivi.VENEZIA, 4);

		MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna, LocalTime.of(12, 30), 70,false);
		MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova, LocalTime.of(6, 00), 90, true);
		MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli, LocalTime.of(10, 30), 130, true);
		MezziDiTrasporto bus4 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_torino, LocalTime.of(14, 00), 58, true);
		MezziDiTrasporto bus5 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_venezia, LocalTime.of(17, 30), 70, true);
		
		MezziDiTrasporto bus6 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_bologna, LocalTime.of(5, 30), 80,true);
		MezziDiTrasporto bus7 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_genova, LocalTime.of(4, 00), 98,true);
		MezziDiTrasporto bus8 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_napoli, LocalTime.of(10, 30), 160,false);
		MezziDiTrasporto bus9 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_torino, LocalTime.of(20, 00), 45,true);
		MezziDiTrasporto bus10 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, firenze_venezia, LocalTime.of(19, 30), 180,true);

		MezziDiTrasporto bus11 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_bologna, LocalTime.of(6, 00), 40, true);
		MezziDiTrasporto bus12 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_genova, LocalTime.of(8, 00), 94, true);
		MezziDiTrasporto bus13 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_napoli, LocalTime.of(10, 30), 120, true);
		MezziDiTrasporto bus14 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_torino, LocalTime.of(16, 00), 55, false);
		MezziDiTrasporto bus15 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, padova_venezia, LocalTime.of(11, 30), 150, true);
		
		MezziDiTrasporto bus16 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_bologna, LocalTime.of(8, 30), 70,true);
		MezziDiTrasporto bus17 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_genova, LocalTime.of(9, 00), 90,false);
		MezziDiTrasporto bus18 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_napoli, LocalTime.of(17, 30), 80,true);
		MezziDiTrasporto bus19 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_torino, LocalTime.of(14, 30), 58,true);
		MezziDiTrasporto bus20 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, milano_venezia, LocalTime.of(19, 30), 60,true);
		
		MezziDiTrasporto bus21 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, roma_bologna, LocalTime.of(9, 30), 68,true);
		MezziDiTrasporto bus22 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, roma_genova, LocalTime.of(10, 00), 95,true);
		MezziDiTrasporto bus23 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, roma_napoli, LocalTime.of(12, 30), 80,true);
		MezziDiTrasporto bus24 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, roma_torino, LocalTime.of(17, 00), 56,true);
		MezziDiTrasporto bus25 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, roma_venezia, LocalTime.of(15, 30), 70, false);
		
		MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.TRAM, milano_bologna, LocalTime.of(8, 30), 70,true);
		MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.TRAM, milano_genova, LocalTime.of(7, 30), 90,true);
		MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.TRAM, milano_napoli, LocalTime.of(10, 30), 80,false);
		MezziDiTrasporto tram4 = new MezziDiTrasporto(TipoMezzi.TRAM, milano_torino, LocalTime.of(14, 00), 58,true);
		MezziDiTrasporto tram5 = new MezziDiTrasporto(TipoMezzi.TRAM, milano_venezia, LocalTime.of(15, 30), 60,true);
		
		MezziDiTrasporto tram6 = new MezziDiTrasporto(TipoMezzi.TRAM, roma_bologna, LocalTime.of(00, 30), 68,false);
		MezziDiTrasporto tram7 = new MezziDiTrasporto(TipoMezzi.TRAM, roma_genova, LocalTime.of(11, 00), 95,true);
		MezziDiTrasporto tram8 = new MezziDiTrasporto(TipoMezzi.TRAM, roma_napoli, LocalTime.of(02, 30), 80,true);
		MezziDiTrasporto tram9 = new MezziDiTrasporto(TipoMezzi.TRAM, roma_torino, LocalTime.of(18, 30), 56,true);
		MezziDiTrasporto tram10 = new MezziDiTrasporto(TipoMezzi.TRAM, roma_venezia, LocalTime.of(13, 30), 70, true);
		
		MezziDiTrasporto tram11 = new MezziDiTrasporto(TipoMezzi.TRAM, como_bologna, LocalTime.of(13, 30), 70,true);
		MezziDiTrasporto tram12 = new MezziDiTrasporto(TipoMezzi.TRAM, como_genova, LocalTime.of(6, 00), 90, true);
		MezziDiTrasporto tram13 = new MezziDiTrasporto(TipoMezzi.TRAM, como_napoli, LocalTime.of(10, 30), 130, true);
		MezziDiTrasporto tram14 = new MezziDiTrasporto(TipoMezzi.TRAM, como_torino, LocalTime.of(14, 00), 58, true);
		MezziDiTrasporto tram15 = new MezziDiTrasporto(TipoMezzi.TRAM, como_venezia, LocalTime.of(17, 30), 70, false);
		
		MezziDiTrasporto tram16 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_bologna, LocalTime.of(7, 30), 80,true);
		MezziDiTrasporto tram17 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_genova, LocalTime.of(8, 30), 98,false);
		MezziDiTrasporto tram18 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_napoli, LocalTime.of(04, 30), 160,true);
		MezziDiTrasporto tram19 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_torino, LocalTime.of(16, 00), 45,true);
		MezziDiTrasporto tram20 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_venezia, LocalTime.of(10, 30), 180,true);
		
		MezziDiTrasporto tram21 = new MezziDiTrasporto(TipoMezzi.TRAM, padova_bologna, LocalTime.of(5, 00), 40, false);
		MezziDiTrasporto tram22 = new MezziDiTrasporto(TipoMezzi.TRAM, padova_genova, LocalTime.of(6, 00), 94, true);
		MezziDiTrasporto tram23 = new MezziDiTrasporto(TipoMezzi.TRAM, padova_napoli, LocalTime.of(12, 40), 120, true);
		MezziDiTrasporto tram24 = new MezziDiTrasporto(TipoMezzi.TRAM, padova_torino, LocalTime.of(14, 30), 55, true);
		MezziDiTrasporto tram25 = new MezziDiTrasporto(TipoMezzi.TRAM, padova_venezia, LocalTime.of(7, 30), 150, true);

		MezziDAO gm = new MezziDAO();

	
		
		// PER ISTANZIARE MEZZI E TRATTE
		
		gm.insertMezzi(bus1);
	    gm.insertMezzi(bus2);
	    gm.insertMezzi(bus3);
	    gm.insertMezzi(bus4);
	    gm.insertMezzi(bus5);
	    gm.insertMezzi(bus6);
	    gm.insertMezzi(bus7);
	    gm.insertMezzi(bus8);
	    gm.insertMezzi(bus9);
	    gm.insertMezzi(bus11);
	    gm.insertMezzi(bus12);
	    gm.insertMezzi(bus13);
	    gm.insertMezzi(bus14);
	    gm.insertMezzi(bus15);
	    gm.insertMezzi(bus16);
	    gm.insertMezzi(bus17);
	    gm.insertMezzi(bus18);
	    gm.insertMezzi(bus19);
	    gm.insertMezzi(bus20);
	    gm.insertMezzi(bus21);
	    gm.insertMezzi(bus22);
	    gm.insertMezzi(bus23);
	    gm.insertMezzi(bus24);
	    gm.insertMezzi(bus25);
	    gm.insertMezzi(tram1);
	    gm.insertMezzi(tram2);
	    gm.insertMezzi(tram3);
	    gm.insertMezzi(tram4);
	    gm.insertMezzi(tram5);
	    gm.insertMezzi(tram6);
	    gm.insertMezzi(tram7);
	    gm.insertMezzi(tram8);
	    gm.insertMezzi(tram9);
	    gm.insertMezzi(tram10);
	    gm.insertMezzi(tram11);
	    gm.insertMezzi(tram12);
	    gm.insertMezzi(tram13);
	    gm.insertMezzi(tram14);
	    gm.insertMezzi(tram15);
	   gm.insertMezzi(tram16);
	    gm.insertMezzi(tram17);
	    gm.insertMezzi(tram18);
	    gm.insertMezzi(tram19);
   gm.insertMezzi(tram20);
	    gm.insertMezzi(tram21);
	    gm.insertMezzi(tram22);
    gm.insertMezzi(tram23);
	    gm.insertMezzi(tram24);
	    gm.insertMezzi(tram25);
	
	  //PARTE DELLO SCANNER
	  		System.out.println("Buongiorno, benvenuto in Azienda trasporti");
	  		// AziendaTrasportiDAO.funzionamento();
	
			
		//
		// Tratta como_genova = new Tratta(Partenze.COMO, Arrivi.GENOVA, 2l);
		// Tratta como_napoli = new Tratta(Partenze.COMO, Arrivi.NAPOLI, 4l);
		// Tratta como_bologna = new Tratta(Partenze.COMO, Arrivi.BOLOGNA, 2l);
		//
		//
		// Tratta firenze_venezia = new Tratta(Partenze.FIRENZE, Arrivi.VENEZIA, 4l);
		// Tratta padova_torino = new Tratta(Partenze.PADOVA, Arrivi.TORINO, 1l);
		// Tratta milano_venezia = new Tratta(Partenze.MILANO, Arrivi.VENEZIA, 4l);
		//
		// MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova,
		// LocalTime.of(10, 30), true);
		// MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli,
		// LocalTime.of(10, 30), false);
		// MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna,
		// LocalTime.of(10, 30), true);
		// MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,
		// firenze_venezia, LocalTime.of(11, 30), false);
		// MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,
		// padova_torino, LocalTime.of(10, 30), true);
		// MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS,
		// milano_venezia, LocalTime.of(10, 30), false);
		//
		//
		//
		// Distributore dist01 = new Distributore(true, "Via dei Suricati 25,
		// Tenerife");
		// Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
		//
		// RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
		// RivenditoreFisico rF02 = new RivenditoreFisico("Via dei Russi 225,
		// Mariupol");
		//
		// Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, dist01);
		// Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false, dist02);
		//
		// Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(1994, 3, 2));
		// Utente ut02 = new Utente("Omar", "Covolo", LocalDate.of(2021, 12, 20));
		//
		// Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), ut01);
		// Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), ut02);
		//
		// Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01,
		// DurataAbbonamento.MENSILE, rF01);
		// Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02,
		// DurataAbbonamento.SETTIMANALE, rF02);
		//
		//
		// UtenteDAO.save(ut01);
		// UtenteDAO.save(ut02);
		//
		// TesseraDAO.save(ts01);
		// TesseraDAO.save(ts02);
		//
		// VenditoreDAO.save(dist01);
		// VenditoreDAO.save(dist02);
		// VenditoreDAO.save(rF01);
		// VenditoreDAO.save(rF02);
		//
		// TitoliDiViaggioDAO.save(bg01);
		// TitoliDiViaggioDAO.save(bg02);
		// TitoliDiViaggioDAO.save(ab01);
		// TitoliDiViaggioDAO.save(ab02);
		//
		// MezziDAO.saveTratta(milano_venezia);
		// MezziDAO.saveTratta(padova_torino);
		// MezziDAO.saveTratta(firenze_venezia);
		// MezziDAO.saveTratta(como_bologna);
		// MezziDAO.saveTratta(como_napoli);
		// MezziDAO.saveTratta(como_genova);
		//
		// MezziDAO.save(tram3);
		// MezziDAO.save(tram2);
		// MezziDAO.save(tram1);
		// MezziDAO.save(bus1);
		// MezziDAO.save(bus2);
		// MezziDAO.save(bus3);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN TITOLODIVIAGGIO PER
		// ID>>>>>>>>>>>>>>>>>>>
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
		TitoloDiViaggio myTv = TitoliDiViaggioDAO.getById(1l);
		Abbonamento b = em.find(Abbonamento.class, 49L);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL
		// PERIODO>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaTitoliDiViaggio(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20));

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL
		// VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaBigliettiDaVenditore(LocalDate.of(2013, 11, 23), LocalDate.of(2023, 5, 20), ven2);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL
		// VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaAbbonamentiDaVenditore(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20), ven1);

		Distributore v = em.find(Distributore.class, 1L);

		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false, v);

		// MezziDiTrasporto m = new MezziDiTrasporto();
		//
		// MezziDAO.save(m);
		// TitoliDiViaggioDAO.save(bg01);
		//
		// TitoliDiViaggioDAO.vidimaBiglietto(bg01, LocalDate.now(), m);

		// MezziDAO.selectTratta(1);

		Tessera myTessera = TesseraDAO.getById(1l);
		TitoloDiViaggio myTv = TitoliDiViaggioDAO.getById(7l);
		Abbonamento b = em.find(Abbonamento.class, 8L);

		// TesseraDAO.verificaValidita(myTessera, b, LocalDate.of(2022, 12, 22));

		TitoliDiViaggioDAO.numeroAbbonamentiUtente(1L);
		TitoliDiViaggioDAO.abbonamentiSingoloUtente(1L);
	}

}