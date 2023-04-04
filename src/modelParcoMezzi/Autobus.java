package modelParcoMezzi;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Autobus")
public class Autobus  extends Mezzi{
	
	private Integer Capienza=60;

	public Autobus(Boolean inServizio, LocalDate dataInizio, LocalDate dataFine) {
		super(inServizio, dataInizio, dataFine);
	}

	public Autobus(Long id, Boolean inServizio, LocalDate dataInizio, LocalDate dataFine) {
		super(id, inServizio, dataInizio, dataFine);
	}

	public Autobus() {
		super();
	}

	public Integer getCapienza() {
		return Capienza;
	}

	@Override
	public String toString() {
		return "Autobus [Capienza=" + Capienza + "]";
	}


}
