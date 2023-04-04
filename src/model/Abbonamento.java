package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.DurataAbbonamento;

@Entity
@DiscriminatorValue("Abbonamento")

public class Abbonamento extends TitoloDiViaggio {
	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	// private LocalDate dataInizioAbbonamento;
	private LocalDate dataScadenza;

	public Abbonamento() {

	}

	public Abbonamento(DurataAbbonamento durataAbbonamento, LocalDate dataEmissione) {
		super(dataEmissione);
		this.durataAbbonamento = durataAbbonamento;
		this.dataScadenza = setDataScadenza();
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

	public LocalDate setDataScadenza() {

		if (durataAbbonamento == DurataAbbonamento.MENSILE) {
			this.dataScadenza = getDataEmissione().plusMonths(1);
		} else if (durataAbbonamento == DurataAbbonamento.SETTIMANALE) {
			this.dataScadenza = getDataEmissione().plusWeeks(1);
		}
		return dataScadenza;
	}

	@Override
	public String toString() {
		return "Abbonamento [durataAbbonamento=" + durataAbbonamento + ", dataScadenza=" + dataScadenza + "]";
	}

}
