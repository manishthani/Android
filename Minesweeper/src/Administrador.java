import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="Administrador")	
@PrimaryKeyJoinColumn(name="username")
public class Administrador extends UsuariRegistrat implements Serializable{
	
	@Column(name="telefono")
	private String tlfn;
	
	public Administrador(){
		super();
	}
	
	public Administrador(String nom, String cognom, String username, String pwd, String tlfn){
		super(nom, cognom, username, pwd);
		this.tlfn = tlfn;
	}
	
	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

}
