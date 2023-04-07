package modelRivendita;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tessere")
public class Tessera implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_attivazione", nullable = false)
	private LocalDate dataAttivazione;

	@Column(name = "data_scadenza", nullable = false)
	private LocalDate dataScadenza;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;

	public Tessera() {
		super();
	}

	public Tessera(Long id, LocalDate dataAttivazione, Utente u) {
		super();
		this.id = id;
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = LocalDate.of(dataAttivazione.getYear() + 1, dataAttivazione.getMonth(),
				dataAttivazione.getDayOfMonth());
		this.utente = u;
	}

	public Tessera(LocalDate dataAttivazione, Utente u) {
		super();
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = LocalDate.of(dataAttivazione.getYear() + 1, dataAttivazione.getMonth(),
				dataAttivazione.getDayOfMonth());
		this.utente = u;
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

	public Utente getUtente() {
		return utente;

	}

	@Override
	public String toString() {
		return "Tessera [id=" + id + ", dataAttivazione=" + dataAttivazione + ", dataScadenza=" + dataScadenza
				+ ", utente=" + utente + "]";
	}

}
