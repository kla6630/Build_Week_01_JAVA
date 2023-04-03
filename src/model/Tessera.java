package model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tessera  implements Serializable {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

}
