package gestionemezzi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tratte")
@Getter
@Setter
@NoArgsConstructor
public class Tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Partenze partenza;
	@Enumerated(EnumType.STRING)
	private Arrivi arrivi;
	private int durataTratta;
	@OneToMany(mappedBy = "tratta")
	private List<MezziDiTrasporto> mezzo;
	
	public Tratta(Partenze partenza, Arrivi arrivi, int durataTratta) {
		super();
		this.partenza = partenza;
		this.arrivi = arrivi;
		this.durataTratta = durataTratta;
	}
	
	public Tratta(int id, Partenze partenza, Arrivi arrivi, int durataTratta, List<MezziDiTrasporto> mezzo) {
		super();
		this.id = id;
		this.partenza = partenza;
		this.arrivi = arrivi;
		this.durataTratta = durataTratta;
		this.mezzo = mezzo;
	}
	

	
	public Tratta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Partenze getPartenza() {
		return partenza;
	}

	public void setPartenza(Partenze partenza) {
		this.partenza = partenza;
	}

	public Arrivi getArrivi() {
		return arrivi;
	}

	public void setArrivi(Arrivi arrivi) {
		this.arrivi = arrivi;
	}

	public int getDurataTratta() {
		return durataTratta;
	}

	public void setDurataTratta(int durataTratta) {
		this.durataTratta = durataTratta;
	}

	public List<MezziDiTrasporto> getMezzo() {
		return mezzo;
	}

	public void setMezzo(List<MezziDiTrasporto> mezzo) {
		this.mezzo = mezzo;
	}

	public Tratta getTratta() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	




	@Override
	public String toString() {
		return partenza.toString() + " - " + arrivi.toString() + ", Durata viaggio=" + durataTratta + "h";
		
	}
}
