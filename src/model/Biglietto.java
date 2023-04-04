package model;

public class Biglietto extends TitoloDiViaggio {
	private Boolean vidimato = false;

	public Boolean getVidimato() {
		return vidimato;
	}

	public void setVidimato(Boolean vidimato) {
		this.vidimato = vidimato;
	}

	public Biglietto(Boolean vidimato) {
		super();
		this.vidimato = vidimato;
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + "]";
	}

}
