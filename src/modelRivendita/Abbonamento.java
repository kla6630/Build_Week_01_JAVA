package modelRivendita;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enums.DurataAbbonamento;

@Entity
//@DiscriminatorValue("Abbonamento")
@Table(name = "abbonamenti")
public class Abbonamento extends TitoloDiViaggio {

	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	// private LocalDate dataInizioAbbonamento;
	private LocalDate dataScadenza;

	@ManyToOne
	private Tessera tessera;

	// scrittura
	public Abbonamento(LocalDate dataEmissione, Tessera tessera, DurataAbbonamento durataAbbonamento,
			Venditore venditore) {
		super(dataEmissione, venditore);
		this.durataAbbonamento = durataAbbonamento;
		this.tessera = tessera;
		setDataScadenza();
	}

	// lettura
	public Abbonamento(Long id, LocalDate dataEmissione,Tessera tessera, DurataAbbonamento durataAbbonamento, LocalDate dataScadenza, Venditore venditore) {
		super(id, dataEmissione, venditore);
		this.durataAbbonamento = durataAbbonamento;
		this.tessera = tessera;
		this.dataScadenza = dataScadenza;
	}

	public Abbonamento() {
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

	public void setDataScadenza() {
		if (durataAbbonamento == DurataAbbonamento.MENSILE) {
			this.dataScadenza = getDataEmissione().plusMonths(1);
		} else if (durataAbbonamento == DurataAbbonamento.SETTIMANALE) {
			this.dataScadenza = getDataEmissione().plusWeeks(1);
		}
	}

	@Override
	public String toString() {
		return "Abbonamento [durataAbbonamento=" + durataAbbonamento + ", dataScadenza=" + dataScadenza + ", tessera="
				+ tessera + "]";
	}


}
