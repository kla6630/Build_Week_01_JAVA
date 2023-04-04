package modelParcoMezzi;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import modelRivendita.Biglietto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Mezzi")
public abstract class Mezzi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean inServizio;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	

	public Mezzi(Boolean inServizio, LocalDate dataInizio, LocalDate dataFine) {
		super();
		this.inServizio = inServizio;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		
	}
	public Mezzi(Long id, Boolean inServizio, LocalDate dataInizio, LocalDate dataFine) {
		super();
		this.id = id;
		this.inServizio = inServizio;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Mezzi() {
	}
	public Boolean getInServizio() {
		return inServizio;
	}
	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "mezzi [id=" + id + ", inServizio=" + inServizio + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + "]";
	}
	
}
