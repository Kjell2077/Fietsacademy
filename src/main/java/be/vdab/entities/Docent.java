package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "docenten")

public class Docent implements Serializable {

private static final long serialVersionUID = 1L;

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String voornaam;
private String familienaam;
private BigDecimal wedde;
private long rijksRegisterNr;

// je maakt getters voor de private variabelen, behalve voor serialVersionUID

public long getId() {
	return id;
}

public String getVoornaam() {
	return voornaam;
}

public String getFamilienaam() {
	return familienaam;
}

public BigDecimal getWedde() {
	return wedde;
}

public long getRijksRegisterNr() {
	return rijksRegisterNr;
}

//default constructor

protected Docent() {
	super();
}

}
