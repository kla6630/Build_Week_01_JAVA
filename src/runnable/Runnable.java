package runnable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import enums.Arrivi;
import enums.DurataAbbonamento;
import enums.Partenze;
import enums.TipoMezzi;
import gestionemezzi.MezziDiTrasporto;
import gestionemezzi.Tratta;
import modelRivendita.Abbonamento;
import modelRivendita.Biglietto;
import modelRivendita.Distributore;
import modelRivendita.RivenditoreFisico;
import modelRivendita.Tessera;
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
	public static void main(String[] args) {

		System.out.println("Buongiorno, benvenuto in Azienda trasporti");
		
		popolaTabellaTrattaEmezzi();
		popolaTabellaVenditori();
		popolaTabellaUtente();

		Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20), UtenteDAO.getById(1l));
		Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20), UtenteDAO.getById(2l));
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE ABBONAMENTI >>>>>>>>>>>>>>>>>>>>>>>>>>
		Abbonamento ab02 = new Abbonamento(LocalDate.of(2023, 12, 20), ts02, DurataAbbonamento.SETTIMANALE, VenditoreDAO.getById(1l));
		Abbonamento ab01 = new Abbonamento(LocalDate.of(2022, 12, 20), ts01, DurataAbbonamento.MENSILE, VenditoreDAO.getById(2l));
		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), VenditoreDAO.getById(1l));
		Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), VenditoreDAO.getById(2l));
		Biglietto bg03 = new Biglietto(LocalDate.of(2022, 8, 15), VenditoreDAO.getById(1l));
		Biglietto bg04 = new Biglietto(LocalDate.of(2023, 2, 3), VenditoreDAO.getById(2l));

		TesseraDAO.save(ts01);
		TesseraDAO.save(ts02);
		TitoliDiViaggioDAO.save(bg01);
		TitoliDiViaggioDAO.save(bg02);
		TitoliDiViaggioDAO.save(bg03);
		TitoliDiViaggioDAO.save(bg04);
		TitoliDiViaggioDAO.save(ab01);
		TitoliDiViaggioDAO.save(ab02);


		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN TITOLODIVIAGGIO PER ID>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.getById(1l);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN MEZZO PER ID>>>>>>>>>>>>>>>>>>>
		MezziDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN VENDITORE PER ID>>>>>>>>>>>>>>>>>>>
		VenditoreDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN UTENTE PER ID>>>>>>>>>>>>>>>>>>>
		UtenteDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UNA TESSERA PER ID>>>>>>>>>>>>>>>>>>>
		TesseraDAO.getById(1l);

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I TITOLI DI VIAGGIO IN BASE AL PERIODO>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaTitoliDiViaggio(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20));

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaBigliettiDaVenditore(LocalDate.of(2013, 11, 23), LocalDate.of(2023, 5, 20), VenditoreDAO.getById(1l));

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA GLI ABBONAMENTI IN BASE AL VENDITORE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaAbbonamentiDaVenditore(LocalDate.of(2022, 12, 10), LocalDate.of(2023, 4, 20), VenditoreDAO.getById(1l));

		// <<<<<<<<<<<<<<<<<<<METODO CHE CONTA IL NUMERO DEGLI ABBONAMENTI IN BASE ALL'UTENTE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.numeroAbbonamentiUtente(1L);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE STAMPA GLI ABBONAMENTI IN BASE ALL'UTENTE>>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.abbonamentiSingoloUtente(1L);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE TRACCIA LE TRATTE>>>>>>>>>>>>>>>>>>>
		MezziDiTrasporto mdz = em.find(MezziDiTrasporto.class, 1L);
		MezziDAO.updateTraccia(mdz);

		// <<<<<<<<<<<<<<<<<<<<<<< METODO CHE CAMBIA LO STATO DI SERVIO DI UN MEZZO
		// >>>>>>>>>>>>>>>>>>>>>>>
		MezziDAO.cambioServizio(mdz);

		// <<<<<<<<<<<<<<<<<<<METODO CHE VIDIMA I BIGLIETTI>>>>>>>>>>>>>>>>>>>

		TitoliDiViaggioDAO.vidimaBiglietto(em.find(Biglietto.class, 1L), LocalDateTime.of(2023, 4, 20, 4, 0), mdz);
		TitoliDiViaggioDAO.vidimaBiglietto(em.find(Biglietto.class, 2L), LocalDateTime.of(2023, 4, 10, 16, 0), mdz);

		// <<<<<<<<<<<<<<<<<<<METODI CHE CONTANO IL NUMERO DEI BIGLIETTI VIDIMATI TOTALI
		// E IN UN DETERMINATO PERIODO >>>>>>>>>>>>>>>>>>>
		TitoliDiViaggioDAO.contaBigliettiVidimatiTotali(mdz);
		TitoliDiViaggioDAO.contaBigliettiVidimatiOraSpecifica(LocalDateTime.of(2023, 4, 20, 4, 0), mdz);
		TitoliDiViaggioDAO.contaBigliettiVidimatiPeriodoSpecifico(LocalDateTime.of(2023, 4, 19, 4, 0),
				LocalDateTime.of(2023, 4, 22, 4, 0), mdz);
		
		// <<<<<<<<<<<<<<<<<<<METODO CHE VERIFICA VALIDITA' TESSERA>>>>>>>>>>>>>>>>>>>
		Abbonamento ab = new Abbonamento(LocalDate.of(2022, 12, 20), em.find(Tessera.class, 1L),
				DurataAbbonamento.MENSILE, em.find(Venditore.class, 1L));
//		TitoliDiViaggioDAO.save(ab);

		if (TesseraDAO.verificaValidita(em.find(Tessera.class, 1L), LocalDate.of(2022, 12, 20))) {
			System.out.println("Il titolo di viaggio in data " + LocalDate.of(2022, 12, 20) + " è attivo.");
		}

		TesseraDAO.rinnovoTessera(em.find(Tessera.class, 1L));
		
	}
	
	public static void popolaTabellaTrattaEmezzi() {

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
		
		MezziDAO.insertTratte(como_bologna);
		MezziDAO.insertTratte(como_genova);
		MezziDAO.insertTratte(como_napoli);
		MezziDAO.insertTratte(como_torino);
		MezziDAO.insertTratte(como_venezia);

		MezziDAO.insertTratte(firenze_venezia);
		MezziDAO.insertTratte(firenze_genova);
		MezziDAO.insertTratte(firenze_napoli);
		MezziDAO.insertTratte(firenze_torino);
		MezziDAO.insertTratte(firenze_bologna);
		
		MezziDiTrasporto bus1 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_bologna, LocalTime.of(12, 30), 70, false);
		MezziDiTrasporto bus2 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_genova, LocalTime.of(6, 00), 90, true);
		MezziDiTrasporto bus3 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_napoli, LocalTime.of(10, 30), 130, true);
		MezziDiTrasporto bus4 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_torino, LocalTime.of(14, 00), 58, true);
		MezziDiTrasporto bus5 = new MezziDiTrasporto(TipoMezzi.AUTOBUS, como_venezia, LocalTime.of(17, 30), 70, true);

		MezziDiTrasporto tram1 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_venezia, LocalTime.of(8, 30), 70, true);
		MezziDiTrasporto tram2 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_bologna, LocalTime.of(7, 30), 90, true);
		MezziDiTrasporto tram3 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_genova, LocalTime.of(10, 30), 80, false);
		MezziDiTrasporto tram4 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_napoli, LocalTime.of(14, 00), 58, true);
		MezziDiTrasporto tram5 = new MezziDiTrasporto(TipoMezzi.TRAM, firenze_torino, LocalTime.of(15, 30), 60, true);
		MezziDAO.insertMezzi(bus1);
		MezziDAO.insertMezzi(bus2);
		MezziDAO.insertMezzi(bus3);
		MezziDAO.insertMezzi(bus4);
		MezziDAO.insertMezzi(bus5);

		MezziDAO.insertMezzi(tram1);
		MezziDAO.insertMezzi(tram2);
		MezziDAO.insertMezzi(tram3);
		MezziDAO.insertMezzi(tram4);
		MezziDAO.insertMezzi(tram5);
			
	}

	public static void popolaTabellaVenditori() {
	
	Distributore dist01 = new Distributore(true, "Via dei Suricati 25,Tenerife");
	Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");

	RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
	RivenditoreFisico rF02 = new RivenditoreFisico("Via da me 225 MariaTeresaCity");

	VenditoreDAO.save(dist01);
	VenditoreDAO.save(dist02);
	VenditoreDAO.save(rF01);
	VenditoreDAO.save(rF02);
		
	}


	public static void popolaTabellaUtente() {
	Utente ut01 = new Utente("Bebo", "Macis", LocalDate.of(1994, 3, 2));
	Utente ut02 = new Utente("Omar", "Covolo", LocalDate.of(2021, 12, 20));
	UtenteDAO.save(ut01);
	UtenteDAO.save(ut02);

}

}
