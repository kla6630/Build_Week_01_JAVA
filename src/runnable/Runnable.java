package runnable;

import java.time.LocalDate;

import enums.DurataAbbonamento;
import model.Abbonamento;
import model.Biglietto;
import model.Distributore;
import model.RivenditoreFisico;
import utils.TitoliDiViaggioDAO;

public class Runnable {

	public static void main(String[] args) {

		Biglietto bg01 = new Biglietto(LocalDate.of(2021, 12, 20), false);
		Biglietto bg02 = new Biglietto(LocalDate.of(2013, 11, 23), false);

		Abbonamento ab01 = new Abbonamento(DurataAbbonamento.MENSILE, LocalDate.of(2022, 12, 20));
		Abbonamento ab02 = new Abbonamento(DurataAbbonamento.SETTIMANALE, LocalDate.of(2023, 12, 20));

		Distributore dist01 = new Distributore(true, "Via dei Suricati 25, Tenerife");
		Distributore dist02 = new Distributore(false, "Via dei Giudei 225, Otranto");

		RivenditoreFisico rF01 = new RivenditoreFisico("Via dei Babbei 50, Salerno");
		RivenditoreFisico rF02 = new RivenditoreFisico("Via dei Russi 225, Mariupol");

		
		//TitoliDiViaggioDAO.save(bg01);
		//TitoliDiViaggioDAO.save(bg02);
		//TitoliDiViaggioDAO.save(ab01);
		//TitoliDiViaggioDAO.save(ab02);
	}

}
