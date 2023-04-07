package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import enums.Arrivi;
import enums.Partenze;
import enums.TipoMezzi;
import gestionemezzi.MezziDiTrasporto;
import gestionemezzi.Tratta;

public class MezziDAO extends Thread {

	private static final String persistenceUnit = "trasporti_db";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	// INSERIMENTO MEZZI NEL DATABASE
	public static void insertMezzi(MezziDiTrasporto mezzo) {

		try {
			MezziDiTrasporto m = mezzo;

			t.begin();
			em.persist(m);
			t.commit();

			System.out.println("Dati mezzo inseriti correttamente!");

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Errore durante l'inserimento dati mezzo");
		}
	}
	
	// INSERIMENTO TRATTE NEL DATABASE
	public static void insertTratte(Tratta tratta) {
		
		try {
			Tratta tr = tratta;
			
			t.begin();
			em.persist(tr);
			t.commit();
			
			System.out.println("Dati tratta inseriti correttamente!");
			
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Errore durante l'inserimento dati tratta");
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
	
	// SELEZIONA LA TRATTA DA ESEGUIRE
	public static void selectTratta(String codice) {
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
			
			switch(i) {
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
		}while(i > 5 | i < 1);

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
			
			switch(z) {
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
		}while(z > 5 | z < 1);
		
		getMezzoByTratta(primo, secondo, codice);
		in.close();
	}
	
	// DOPO CHE L'UTENTE HA SCELTO LA TRATTA CHE VUOLE PERCORRERE GLI VIENE COMUNICATO QUALI MEZZI PUO PRENDERE
	public static void getMezzoByTratta(Partenze p, Arrivi a , String codice) {
		Scanner in = new Scanner(System.in);
		Query q = em.createQuery("SELECT m FROM Tratta m WHERE partenza = :n AND arrivi = :a ");
		q.setParameter("n", p);
		q.setParameter("a", a);
		List<Tratta> result = q.getResultList();
		
		if (result.isEmpty()) {
			System.out.println("For tratta: " + p + " - " + a + " --> element not found!");
		} else {
			for (Tratta tratta : result) {
				List<MezziDiTrasporto> m = tratta.getMezzo();
				
				Stream<MezziDiTrasporto> s = m.stream().filter((param) -> param.isServizio() == true);
				
				
				if(m.stream().filter((param) -> param.isServizio() == true).findAny().isPresent() && m.stream().filter((param) -> param.isServizio() == true).count() == 1) {
					System.out.println("Per tratta: " + p + " - " + a + " è in servizio il seguente mezzo:");
					tratta.getMezzo().stream().filter((param) -> param.isServizio() == true).forEach(param -> System.out.println( "⊛ " + param));
					tratta.getMezzo().stream().filter((param) -> param.isServizio() == true).forEach(param -> {
						System.out.println();
						run(param);
						updateTraccia(param);
						try {
							//.recuperaIdBiglietto(codice);
						}
						catch(Exception e) {
							
						}
					});
				}else if(m.stream().filter((param) -> param.isServizio() == true).findAny().isPresent() && m.stream().filter((param) -> param.isServizio() == true).count() > 1) {
					System.out.println("Per tratta: " + p + " - " + a + " sono in servizio i seguenti mezzi:");
					tratta.getMezzo().stream().filter((param) -> param.isServizio() == true).forEach(param -> System.out.println( "⊛ " + param));
					try {
						System.out.println("Su quale vuoi salire? \n Digita il NumeroMezzo del mezzo che vuoi prendere");
						long num = in.nextInt();
						if(tratta.getMezzo().stream().filter((param) -> param.getId() == num).findAny().isPresent()) {
							tratta.getMezzo().stream().filter((param) -> param.getId() == num).forEach(param -> {
							System.out.println();	
							run(param);
							updateTraccia(param);
							try {
								//recuperaIdBiglietto(codice);
							}
							catch(Exception e) {
								
							}
							});
						} else {
							System.out.println("ERROR: non c'è nessun mezzo con num=" + num + " per la tratta "+ p + " - " + a );
							System.out.println("Riseleziona la tratta che vuoi percorrere");
							selectTratta(codice);
						}
					} catch(Exception e) {
						System.out.println("ERROR: non hai selezionato un formato numerico!");
						System.out.println("Riseleziona la tratta che vuoi percorrere");
						selectTratta(codice);
					}
				} else {
					System.out.println("Tutti i mezzi per la tratta selezionata sono fuori servizio");
					System.out.println("Seleziona un'altra tratta");
					selectTratta(codice);
				}
			}
		}
		in.close();
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<< METODO CHE CAMBIA LO STATO DI SERVIO DI UN MEZZO >>>>>>>>>>>>>>>>>>>>>>>
	public static void cambioServizio(MezziDiTrasporto tr) {
		try {
			em.getTransaction().begin();
			

			if (tr != null) {
				System.out.println(tr);
				tr.setDataCambio(LocalDate.now());
				tr.setServizio(!tr.isServizio());
				em.getTransaction().commit();
				System.out.println(tr);
				System.out.println("Stato servizio cambiato");
			} else
				throw new Exception("Mezzo non trovato");

		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("errore cambio servizio" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// SI FA L'UPDATE DI QUANTE VOLTE è STATA PERCORSA UNA DETERMINATA TRATTA
	public static void updateTraccia(MezziDiTrasporto result) {
		t.begin();
		MezziDiTrasporto b = em.find(MezziDiTrasporto.class, result.getId());
		int tr = b.getTraccia() + 1;
		b.setTraccia(tr);
		
		t.commit();
		System.out.println();
		System.out.println("➱ " + b.getTipoMezzi() + " num=" + b.getId() + " ha percorso " + b.getTraccia() + " volte la tratta " + b.getTratta().getPartenza() + " - " + b.getTratta().getArrivi());
		System.out.println("Sei arrivato a destinazione in " + b.getTratta().getDurataTratta() + "h");
	}

	// METODO PER SIMULARE IL VIAGGIO CON EMOJI
	public static void run(MezziDiTrasporto result) {
        for(int i = 1; i <= (result.getTratta().getDurataTratta()*10) ; i++) {
        	if(result.getTipoMezzi() == TipoMezzi.AUTOBUS) {
        		 System.out.print("🚌");
        	}else {
        		System.out.print("🚎");
        	}
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
            }
        }
        System.out.println();
	}
}
