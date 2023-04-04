package modelParcoMezzi;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Tram")
public class Tram extends Mezzi {

	private Integer Capienza = 40;

	public Tram(Boolean inServizio, LocalDate dataInizio, LocalDate dataFine, Integer capienza) {
		super(inServizio, dataInizio, dataFine);
		Capienza = capienza;
	}

	public Tram() {
		super();
	}

	public Integer getCapienza() {
		return Capienza;
	}

	@Override
	public String toString() {
		return "Tram [Capienza=" + Capienza + "]";
	}

}
