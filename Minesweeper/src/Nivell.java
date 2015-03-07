import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Nivell")


public class Nivell implements Serializable{
	
	@Id
	private String nom;
	

	private Integer nombreCasellesXFila;
	

	private Integer nombreCasellesXColumna;
	
	@Column(name="nMines")
	private Integer nombreMines;
	
	
	@OneToMany(mappedBy="nivell",cascade= CascadeType.ALL)
	private Set<Partida> partides;

	public Nivell(){}
	
	public Nivell(String nom, Integer nombreCasellesXFila, Integer nombreCasellesXColumna, Integer nombreMines){
		this.nom = nom;
		this.nombreCasellesXFila = nombreCasellesXFila;
		this.nombreCasellesXColumna = nombreCasellesXColumna;
		this.nombreMines = nombreMines;
		partides =  new HashSet<Partida>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNombreCasellesXFila() {
		return nombreCasellesXFila;
	}

	public void setNombreCasellesXFila(Integer nombreCasellesXFila) {
		this.nombreCasellesXFila = nombreCasellesXFila;
	}

	public Integer getNombreCasellesXColumna() {
		return nombreCasellesXColumna;
	}

	public void setNombreCasellesXColumna(Integer nombreCasellesXColumna) {
		this.nombreCasellesXColumna = nombreCasellesXColumna;
	}

	public Integer getNombreMines() {
		return nombreMines;
	}

	public void setNombreMines(Integer nombreMines) {
		this.nombreMines = nombreMines;
	}

	public Set<Partida> getPartides() {
		return partides;
	}

	public void setPartides(Set<Partida> partides) {
		this.partides = partides;
	}
	
}
