
public class ControladorCasoDeUsoLogin {
	private String userN;
	private String passwd; 
	public ControladorCasoDeUsoLogin(){}
	
	public ControladorCasoDeUsoLogin(String userN, String passwd) {
		this.userN = userN;
		this.passwd = passwd;
	}

	public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean login(){
		return true;
		
	}
}
