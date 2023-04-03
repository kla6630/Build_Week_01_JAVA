package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

public class Utente implements Serializable {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long  id;
	private String nome;
	private String  cognome;
	private LocalDate dataDiNascita;
	

}
