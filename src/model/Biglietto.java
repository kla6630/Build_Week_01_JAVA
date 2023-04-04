package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Biglietto")
public class Biglietto extends TitoloDiViaggio {

	private Boolean vidimato = false;

	public Biglietto(Boolean vidimato) {
		super();
		this.vidimato = vidimato;
	}

	public Biglietto() {

	}

	public Biglietto(LocalDate dataEmissione, Boolean vidimato) {
		super(dataEmissione);
		this.vidimato = vidimato;
	}

	public Boolean getVidimato() {
		return vidimato;
	}

	public void setVidimato(Boolean vidimato) {
		this.vidimato = vidimato;
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + "]";
	}

}
