package gestionemezzi;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enums.TipoMezzi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "mezziditrasporto")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MezziDiTrasporto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private TipoMezzi tipoMezzi;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tratta_id", referencedColumnName = "id")
	private Tratta tratta;
	private LocalTime oraPartenza;
	private LocalTime oraArrivo;
	private boolean servizio;
	private int traccia;

	public MezziDiTrasporto(TipoMezzi tipoMezzi, Tratta tratta, LocalTime oraPartenza, boolean servizio) {
		super();
		this.tipoMezzi = tipoMezzi;
		this.tratta = tratta;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraPartenza.plusHours(tratta.getDurataTratta());
		this.servizio = servizio;
	}

	public MezziDiTrasporto(long id, TipoMezzi tipoMezzi, Tratta tratta, LocalTime oraPartenza, LocalTime oraArrivo, boolean servizio, int traccia) {
		super();
		this.id = id;
		this.tipoMezzi = tipoMezzi;
		this.tratta = tratta;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
		this.servizio = servizio;
		this.traccia = traccia;
	}

	public MezziDiTrasporto() {
		super();
	}

	public TipoMezzi getTipoMezzi() {
		return tipoMezzi;
	}

	public void setTipoMezzi(TipoMezzi tipoMezzi) {
		this.tipoMezzi = tipoMezzi;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public LocalTime getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(LocalTime oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public LocalTime getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public boolean isServizio() {
		return servizio;
	}

	public void setServizio(boolean servizio) {
		this.servizio = servizio;
	}

	public int getTraccia() {
		return traccia;
	}

	public void setTraccia(int traccia) {
		this.traccia = traccia;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NumeroMezzo=" + id + ", TipoMezzo=" + tipoMezzi + ", " + tratta + " | Partenza: " + oraPartenza
				+ ", Arrivo: " + oraArrivo + ", Servizio: " + servizio;

	}

}
