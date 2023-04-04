package runnable;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import dbconnection.DbConnection;
import enums.DurataAbbonamento;
import modelRivendita.Abbonamento;
import modelRivendita.Biglietto;
import modelRivendita.Distributore;
import modelRivendita.RivenditoreFisico;
import modelRivendita.Tessera;
import modelRivendita.Utente;
import utils.TitoliDiViaggioDAO;
import utils.VenditoreDAO;

public class Runnable {
	
	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();
	
	public static void main(String[] args) {
		
		Distributore dist01 = new Distributore(true, "Via dei Suricati 25, Tenerife");
		Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");
		
		RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
		RivenditoreFisico rF02 = new RivenditoreFisico("Via dei Russi 225, Mariupol");

		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false,dist01);
		Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false,dist02);

		Abbonamento ab01 = new Abbonamento(DurataAbbonamento.MENSILE, LocalDate.of(2022, 12, 20),rF01);
		Abbonamento ab02 = new Abbonamento(DurataAbbonamento.SETTIMANALE, LocalDate.of(2023, 12, 20),rF02);

		Tessera ts01 = new Tessera(LocalDate.of(2021, 12, 20));
		Tessera ts02 = new Tessera(LocalDate.of(2021, 8, 20));
		
		Utente ut01 = new Utente("Bebo","Macis",LocalDate.of(2021, 12, 20),ts02 );
		
		VenditoreDAO.save(dist01);
		VenditoreDAO.save(dist02);
		VenditoreDAO.save(rF01);
		VenditoreDAO.save(rF02);
	
		
		TitoliDiViaggioDAO.save(bg01);
		TitoliDiViaggioDAO.save(bg02);
		TitoliDiViaggioDAO.save(ab01);
		TitoliDiViaggioDAO.save(ab02);
	}

}
