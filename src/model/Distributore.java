package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Distributore_automatico")
public class Distributore extends Venditore {
	private Boolean statusAttivo;

	public Distributore(Boolean statusAttivo, String indirizzo) {
		super(indirizzo);
		this.statusAttivo = statusAttivo;
	}

	public Distributore(Boolean statusAttivo, String indirizzo, Long id) {
		super(id, indirizzo);
		this.statusAttivo = statusAttivo;
	}

	public Distributore() {
		super();

	}

	public Boolean getStatusAttivo() {
		return statusAttivo;
	}

	public void setStatusAttivo(Boolean statusAttivo) {
		this.statusAttivo = statusAttivo;
	}

	@Override
	public String toString() {
		return "Distributore [statusAttivo=" + statusAttivo + "]";
	}

}
