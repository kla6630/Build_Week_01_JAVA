package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Titolo_di_Viaggio")
public abstract class TitoloDiViaggio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Venditore venditore;

	private LocalDate dataEmissione;

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Long getId() {
		return id;
	}

	public TitoloDiViaggio(Long id, LocalDate dataEmissione) {
		super();
		this.id = id;
		this.dataEmissione = dataEmissione;
	}

	public TitoloDiViaggio(LocalDate dataEmissione) {
		super();
		this.dataEmissione = dataEmissione;
	}

	public TitoloDiViaggio() {

	}

	@Override
	public String toString() {
		return "TitoloDiViaggio [id=" + id + ", dataEmissione=" + dataEmissione + "]";
	}

}
