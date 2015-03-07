import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Jugador")
@PrimaryKeyJoinColumn(name="username")
public class Jugador extends UsuariRegistrat implements Serializable{
	
	
	private String email;
	
	@OneToOne
	private Partida partidaActual;
	
	@OneToMany(mappedBy="jugadorPartidaJugada",cascade= CascadeType.ALL)
	private Set<Partida> partidaJugada;
	
	public Jugador(){}
	
	public Jugador(String nom, String cognom, String username, String pwd, String email){
		super(nom, cognom, username, pwd);
		this.email = email;
		this.partidaActual = null;
		partidaJugada = new HashSet<Partida>();
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}

	public Set<Partida> getPartidaJugada() {
		return partidaJugada;
	}

	public void setPartidaJugada(Set<Partida> partidaJugada) {
		this.partidaJugada = partidaJugada;
	}
	
	public void addPartidaJugada(Partida partida){
		partidaJugada.add(partida);
	}
	
	
}
