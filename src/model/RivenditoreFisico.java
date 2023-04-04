package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rivenditore Fisico")
public class RivenditoreFisico extends Venditore {

<<<<<<< Updated upstream
	public RivenditoreFisico(String indirizzo) {
		super(indirizzo);

	}

	public RivenditoreFisico() {
		super();

	}

	@Override
	public String toString() {
		return "RivenditoreFisico [getIndirizzo()=" + getIndirizzo() + ", getId()=" + getId() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
=======
>>>>>>> Stashed changes

}
