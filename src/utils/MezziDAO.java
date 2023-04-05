package utils;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import dbconnection.DbConnection;
import enums.Arrivi;
import enums.Partenze;
import gestionemezzi.MezziDiTrasporto;
import gestionemezzi.Tratta;
import modelRivendita.Biglietto;
import modelRivendita.TitoloDiViaggio;

public class MezziDAO {
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	// <<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN MEZZO ALLA TABELLA>>>>>>>>>>>>>>>>>>>
	public static void save(MezziDiTrasporto mz) {
		try {
			em.getTransaction().begin();
			em.persist(mz);
			em.getTransaction().commit();
			System.out.println("Ho slavato");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + mz.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
	public static MezziDiTrasporto getById(Long id) {
		try {
			em.getTransaction().begin();
			MezziDiTrasporto e = em.find(MezziDiTrasporto.class, id);
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

	// <<<<<<<<<<<<<<<<<<<<<<<<<< MODIFICA MEZZO >>>>>>>>>>>>>>>>>>>>>>>>>>
	public static void updateEvento(MezziDiTrasporto mz) {
		em.getTransaction().begin();
		em.merge(mz);
		em.getTransaction().commit();
		System.out.println("Utente modificato nel database");
		System.out.println(mz);
	}

	// <<<<<<<<<<<<<<<<<<<<<METODO CHE CONTA I BIGLIETTI VIDIMATI>>>>>>>>>>>>>>>>>>>>>
	public static void vidimaBiglietto(Biglietto bi) {
		Integer numVidimati = 0;

		if (bi.getVidimato()) {
			numVidimati += 1;
			bi.setVidimato(true);
		}
	}

	// SELEZIONA LA TRATTA DA ESEGUIRE

	public static void selectTratta(int codice) {
		Scanner in = new Scanner(System.in);
		int i;
		Partenze primo = null;
		do {
			System.out.println("Seleziona stazione di partenza:");
			System.out.println(" 1 > Como");
			System.out.println(" 2 > Milano");
			System.out.println(" 3 > Firenze");
			System.out.println(" 4 > Padova");
			System.out.println(" 5 > Roma");
			i = in.nextInt();

			switch (i) {
			case 1:
				primo = Partenze.COMO;
				break;
			case 2:
				primo = Partenze.MILANO;
				break;
			case 3:
				primo = Partenze.FIRENZE;
				break;
			case 4:
				primo = Partenze.PADOVA;
				break;
			case 5:
				primo = Partenze.ROMA;
				break;
			default:
				System.out.println("ERROR. Numero selezionato errato!");
				System.out.println("RISELEZIONE ATTIVATA");
			}
		} while (i > 5 | i < 1);

		int z;
		Arrivi secondo = null;
		do {
			System.out.println("Seleziona stazione di arrivo:");
			System.out.println(" 1 > Napoli");
			System.out.println(" 2 > Bologna");
			System.out.println(" 3 > Genova");
			System.out.println(" 4 > Torino");
			System.out.println(" 5 > Venezia");
			z = in.nextInt();

			switch (z) {
			case 1:
				secondo = Arrivi.NAPOLI;
				break;
			case 2:
				secondo = Arrivi.BOLOGNA;
				break;
			case 3:
				secondo = Arrivi.GENOVA;
				break;
			case 4:
				secondo = Arrivi.TORINO;
				break;
			case 5:
				secondo = Arrivi.VENEZIA;
				break;
			default:
				System.out.println("ERROR. Numero selezionato errato!");
				System.out.println("RISELEZIONE ATTIVATA");
			}
		} while (z > 5 | z < 1);

		getMezzoByTratta(primo, secondo, codice);
		in.close();
	}

	private static void getMezzoByTratta(Partenze primo, Arrivi secondo, int codice) {
		// TODO Auto-generated method stub

	}
	
	public static void saveTratta(Tratta tr) {
		try {
			em.getTransaction().begin();
			em.persist(tr);
			em.getTransaction().commit();
			System.out.println("Ho salvato");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore di salvataggio: " + tr.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}
	
	
	
}
