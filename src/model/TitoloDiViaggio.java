package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class TitoloDiViaggio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataEmissione;

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Long getId() {
		return id;
	}

	public TitoloDiViaggio(Long id, LocalDate dataEmissione) {
		super();
		this.id = id;
		this.dataEmissione = dataEmissione;
	}

	public TitoloDiViaggio(LocalDate dataEmissione) {
		super();
		this.dataEmissione = dataEmissione;
	}

	public TitoloDiViaggio() {

	}

	@Override
	public String toString() {
		return "TitoloDiViaggio [id=" + id + ", dataEmissione=" + dataEmissione + "]";
	}

}
