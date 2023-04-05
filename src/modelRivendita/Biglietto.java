package modelRivendita;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gestionemezzi.MezziDiTrasporto;

@Entity
//@DiscriminatorValue("Biglietto")
@Table(name = "biglietti")
public class Biglietto extends TitoloDiViaggio {

	private Boolean vidimato = false;

	@Column(name = "data_ora_vidimazione")
	private LocalDateTime dataOraVidimazione;

	@ManyToOne
	@JoinColumn(name = "id_mezzo", nullable = true)
	private MezziDiTrasporto mezzo;

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

	public LocalDateTime getDataOraVidimazione() {
		return dataOraVidimazione;
	}

	public void setDataOraVidimazione(LocalDateTime dataOraVidimazione) {
		this.dataOraVidimazione = dataOraVidimazione;
	}

	public void vidimaBiglietto(LocalDateTime data, MezziDiTrasporto mezzo) throws Exception {
		this.dataOraVidimazione = data;
		this.mezzo = mezzo;
		if (!this.vidimato)
			this.vidimato = true;
		else {
			throw new Exception("biglietto già vidimato");
		}
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", dataVidimazione = " + dataOraVidimazione + "]";
	}
}
