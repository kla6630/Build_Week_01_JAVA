package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tessera implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataAttivazione;
	private LocalDate dataScadenza;

	public Tessera(Long id, LocalDate dataAttivazione, LocalDate dataScadenza) {
		super();
		this.id = id;
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = dataScadenza;
	}

	public Tessera(LocalDate dataAttivazione, LocalDate dataScadenza) {
		super();
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = dataScadenza;
	}

	public LocalDate getDataAttivazione() {
		return dataAttivazione;
	}

	public void setDataAttivazione(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tessera [id=" + id + ", dataAttivazione=" + dataAttivazione + ", dataScadenza=" + dataScadenza + "]";
	}

}
