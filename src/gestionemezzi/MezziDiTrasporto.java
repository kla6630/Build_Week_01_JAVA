package gestionemezzi;

import java.time.LocalDate;
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
import javax.persistence.Table;

import enums.TipoMezzi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="mezziditrasporto")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MezziDiTrasporto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	private TipoMezzi tipoMezzi;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "tratta_id", referencedColumnName = "id")
	private Tratta tratta;

	private LocalTime oraPartenza;
	private LocalTime oraArrivo;
	private int capienza;
	private LocalDate dataCambio;
	private boolean servizio;
	private int traccia;
	
	public MezziDiTrasporto(TipoMezzi tipoMezzi, Tratta tratta, LocalTime oraPartenza,
			int capienza, boolean servizio) {
		super();
		this.tipoMezzi = tipoMezzi;
		this.tratta = tratta;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraPartenza.plusHours(getTratta().getDurataTratta());
		this.capienza = capienza;
		this.servizio = servizio;
	}
	
	public MezziDiTrasporto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
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

	public LocalDate getDataCambio() {
		return this.dataCambio;
	}

	public void setDataCambio(LocalDate data) {
		this.dataCambio = data;
	}
	
	@Override
	public String toString() {
		return "NumeroMezzo=" + id + ", TipoMezzo=" + tipoMezzi + ", " + tratta + " | Partenza: " + oraPartenza + ", Arrivo: " + oraArrivo + ", Servizio: " + servizio;
	}
}