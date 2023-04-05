package modelRivendita;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("Biglietto")
@Table(name = "biglietti")
public class Biglietto extends TitoloDiViaggio {

	private Boolean vidimato = false;

	@Column(name = "data_vidimazione")
	private LocalDate dataVidimazione;

	public Biglietto() {

	}

	public Biglietto(LocalDate dataEmissione, Boolean vidimato, Venditore venditore) {
		super(dataEmissione, venditore);
		this.vidimato = vidimato;
	}

	public Biglietto(Long id, LocalDate dataEmissione, Boolean vidimato, Venditore venditore) {
		super(id, dataEmissione, venditore);
		this.vidimato = vidimato;
	}

	public Boolean getVidimato() {
		return vidimato;
	}

	public void setVidimato(Boolean vidimato) {
		this.vidimato = vidimato;
	}

	public void vidimaBiglietto(LocalDate data) throws Exception {
		this.dataVidimazione = data;
		if (!this.vidimato)
			this.vidimato = true;
		else {
			throw new Exception("biglietto già vidimato");
		}
	}


	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", dataVidimazione = " + dataVidimazione + "]";
	}

}
