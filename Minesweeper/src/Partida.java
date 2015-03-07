import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Partida")

public class Partida implements Serializable {

	@Id
	private Integer idPartida;
	
	private Boolean estaAcabada;
	
	private Boolean estaGuanyada;
	
	private Integer nombreTirades;
	
	
	@Transient
	private Casella[][] caselles;
	
	@ManyToOne 
	@JoinColumn(name="jugadorPartidaJugada")
	private Jugador jugadorPartidaJugada; //Relacion 0..1 - *
	
	@OneToOne
	private Jugador jugadorPartidaActual;
	
	@Transient
	private IEstrategiaPuntuacio estrategia;
	
	
	@ManyToOne 
	@JoinColumn(name="nomNivell")
	private Nivell nivell;
	
	public Partida(){}
	
	public Partida(Integer idPartida, Boolean estaAcabada, Boolean estaGuanyada, Integer nombreTirades){
		this.idPartida = idPartida;
		this.estaAcabada = estaAcabada;
		this.estaGuanyada = estaGuanyada;
		this.nombreTirades = nombreTirades;
		this.jugadorPartidaActual = null;
		this.jugadorPartidaJugada = null;
		int randomEstrategia = (int)(Math.random() * 2 + 1);
		if(randomEstrategia == 1) setEstrategia(new EstrategiaPuntuacioTiempo());
		else setEstrategia(new EstrategiaPuntuacioTirades());
	}

	public Integer getIdPartida() {
		return idPartida;
	}
	
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	
	public Boolean getEstaAcabada() {
		return estaAcabada;
	}
	
	public void setEstaAcabada(Boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	
	public Boolean getEstaGuanyada() {
		return estaGuanyada;
	}
	
	public void setEstaGuanyada(Boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	
	public Integer getNombreTirades() {
		return nombreTirades;
	}
	
	public void setNombreTirades(Integer nombreTirades) {
		this.nombreTirades = nombreTirades;
	}
	
	public Casella[][] getCaselles() {
		return caselles;
	}
	public Casella getCasellaAtIndex(Integer i, Integer j){
		return caselles[i][j];
	}

	public void setCasellaAtIndex(Casella casella, Integer i, Integer j){
		caselles[i][j] = casella;
	}
	public void createCaselles(Integer nombreCasellesXFila,Integer nombreCasellesXColumna ) {
		caselles = new Casella[nombreCasellesXFila][nombreCasellesXColumna];
	}
	
	public IEstrategiaPuntuacio getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(IEstrategiaPuntuacio estrategia) {
		this.estrategia = estrategia;
	}
	
	public int calcularPuntuacio(){
		return estrategia.calcularPuntuacio(this);
	}

	public Nivell getNivell() {
		return nivell;
	}

	public void setNivell(Nivell nivell) {
		this.nivell = nivell;
	}

	public Jugador getJugadorPartidaJugada() {
		return jugadorPartidaJugada;
	}

	public void setJugadorPartidaJugada(Jugador jugadorPartidaJugada) {
		this.jugadorPartidaJugada = jugadorPartidaJugada;
	}

	public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}

	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}
	
	public void incrementarNumeroCasellesVeines(Integer i, Integer j){
		//Comprueban fila inferior
		if(i + 1 < caselles.length) {
			caselles[i+1][j].setNumero(caselles[i+1][j].getNumero() + 1);
			if(j + 1 < caselles[0].length) caselles[i+1][j+1].setNumero(caselles[i+1][j+1].getNumero() + 1);
			if(j-1 >= 0) caselles[i+1][j-1].setNumero(caselles[i+1][j-1].getNumero() + 1);
		}
		//Comprueba Fila superior
		if(i - 1 >= 0) {
			caselles[i-1][j].setNumero(caselles[i-1][j].getNumero() + 1);
			if(j + 1 < caselles[0].length) caselles[i-1][j+1].setNumero(caselles[i-1][j+1].getNumero() + 1);
			if(j-1 >= 0) caselles[i-1][j-1].setNumero(caselles[i-1][j-1].getNumero() + 1);
		}
		//Comprueba casilla que esta a la izquierda y a la derecha
		if(j + 1 < caselles[0].length) caselles[i][j+1].setNumero(caselles[i][j+1].getNumero() + 1);
		if(j - 1 >= 0) caselles[i][j-1].setNumero(caselles[i][j-1].getNumero() + 1);
	}
	
	public void descobrirCasellesVeines(Integer i, Integer j){
		//Comprueban fila inferior
		if(i + 1 < caselles.length) {
			caselles[i+1][j].setEstaDescoberta(true);
			if(j + 1 < caselles[0].length) caselles[i+1][j+1].setEstaDescoberta(true);
			if(j-1 >= 0) caselles[i-1][j].setEstaDescoberta(true);
		}
		//Comprueba Fila superior
		if(i - 1 >= 0) {
			caselles[i-1][j].setEstaDescoberta(true);
			if(j + 1 < caselles[0].length)  caselles[i-1][j+1].setEstaDescoberta(true);
			if(j-1 >= 0) caselles[i-1][j-1].setEstaDescoberta(true);

		}
		//Comprueba casilla que esta a la izquierda y a la derecha
		if(j + 1 < caselles[0].length) caselles[i][j+1].setEstaDescoberta(true);;
		if(j - 1 >= 0) caselles[i][j-1].setEstaDescoberta(true);
	}
	
}
