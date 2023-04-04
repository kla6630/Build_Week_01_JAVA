package model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.DurataAbbonamento;

public class Abbonamento extends TitoloDiViaggio {
	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	// private LocalDate dataInizioAbbonamento;
	private LocalDate dataScadenza;

	public Abbonamento(DurataAbbonamento durataAbbonamento, LocalDate dataScadenza, LocalDate dataEmissione) {
		super(dataEmissione);
		this.durataAbbonamento = durataAbbonamento;
		this.dataScadenza = dataScadenza;
	}

	public Abbonamento(Long id, LocalDate dataEmissione, DurataAbbonamento durataAbbonamento, LocalDate dataScadenza) {
		super(id, dataEmissione);
		this.durataAbbonamento = durataAbbonamento;
		this.dataScadenza = dataScadenza;
	}

	public DurataAbbonamento getDurataAbbonamento() {
		return durataAbbonamento;
	}

	public void setDurataAbbonamento(DurataAbbonamento durataAbbonamento) {
		this.durataAbbonamento = durataAbbonamento;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return "Abbonamento [durataAbbonamento=" + durataAbbonamento + ", dataScadenza=" + dataScadenza + "]";
	}

}
