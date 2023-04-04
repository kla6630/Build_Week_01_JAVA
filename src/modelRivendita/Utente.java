package modelRivendita;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="utenti")
public class Utente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false, name="data_di_nascita")
	private LocalDate dataDiNascita;
	
	@OneToMany( mappedBy = "utente")
	private List<Tessera> tessere=new ArrayList<Tessera>();

	


	public Utente() {
		super();
	}

	public Utente(Long id, String nome, String cognome, LocalDate dataDiNascita, Tessera tessera) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.tessere.add(tessera) ;
	}

	public Utente(String nome, String cognome, LocalDate dataDiNascita, Tessera tessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.tessere.add(tessera) ;
	}

	public List<Tessera> getTessere() {
		return tessere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ "]";
	}

}
