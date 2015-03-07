import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="BuscaMines")

public class BuscaMines implements Serializable{
	private static BuscaMines buscamines = new BuscaMines();
	
	@Id
	@Column(name="idPartida")
	private Integer idPartida = 0;
	
	private BuscaMines(){}
	
	private BuscaMines(Integer idPartida){
		this.idPartida = idPartida;
	}
	
	public static BuscaMines getInstance(){
		return buscamines;
	}
	public void incrementarIdPartida(){
		++idPartida;
	}
	public Integer getIdPartida(){
		return idPartida;
	}
}
