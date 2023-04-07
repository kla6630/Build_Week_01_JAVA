package modelRivendita;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "Titolo_di_Viaggio")
public abstract class TitoloDiViaggio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	private Venditore venditore;

	@Column(name = "data_emissione")
	private LocalDate dataEmissione;

	public TitoloDiViaggio(Long id, LocalDate dataEmissione,Venditore venditore) {
		super();
		this.id = id;
		this.dataEmissione = dataEmissione;
		this.venditore = venditore;
	}
	
	public TitoloDiViaggio(LocalDate dataEmissione, Venditore venditore) {
		super();
		this.dataEmissione = dataEmissione;
		this.venditore = venditore;
	}
	
	public TitoloDiViaggio() {
		
	}
	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	
	}

	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "TitoloDiViaggio [id=" + id + ", dataEmissione=" + dataEmissione + ", venditore=" + venditore + "]";
	}

}
