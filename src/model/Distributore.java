package model;

public class Distributore extends Venditore {
	private Boolean statusAttivo;

	public Boolean getStatusAttivo() {
		return statusAttivo;
	}

	public void setStatusAttivo(Boolean statusAttivo) {
		this.statusAttivo = statusAttivo;
	}

	public Distributore(Boolean statusAttivo) {
		super();
		this.statusAttivo = statusAttivo;
	}

	@Override
	public String toString() {
		return "Distributore [statusAttivo=" + statusAttivo + "]";
	}

}
