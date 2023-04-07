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

	public Biglietto(LocalDate dataEmissione, Venditore venditore) {
		super(dataEmissione, venditore);
	}

	public Biglietto(Long id, LocalDate dataEmissione, Venditore venditore) {
		super(id, dataEmissione, venditore);
	}

	public Boolean getVidimato() {
		return vidimato;
	}

	private void setVidimato(Boolean vidimato) {
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
			setVidimato(true);
		else {
			throw new Exception("biglietto già vidimato");
		}
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", dataVidimazione = " + dataOraVidimazione + "]";
	}
}
