package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class TitoloDiViaggio implements Serializable {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  
	private Long id;
	private LocalDate dataEmissione;

}
