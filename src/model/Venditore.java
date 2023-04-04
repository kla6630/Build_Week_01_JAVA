package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "venditore")
@DiscriminatorColumn(name = "Tipo_di_rivendita")
//SUPERCLASSE//
public abstract class Venditore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String indirizzo;

	// costruttore con id//
	public Venditore(Long id, String indirizzo) {
		super();
		this.id = id;
		this.indirizzo = indirizzo;
	}

	// costruttore senza id//
	public Venditore(String indirizzo) {
		super();
		this.indirizzo = indirizzo;
	}

	public Venditore() {
		super();

	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Venditore [id=" + id + ", indirizzo=" + indirizzo + "]";
	}

}
