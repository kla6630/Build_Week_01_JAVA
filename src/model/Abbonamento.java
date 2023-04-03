package model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.DurataAbbonamento;

public class Abbonamento extends TitoloDiViaggio {
	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	// private LocalDate  dataInizioAbbonamento;
	private LocalDate dataScadenza;
	

}
