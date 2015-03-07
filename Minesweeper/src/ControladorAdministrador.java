import java.util.ArrayList;

public class ControladorAdministrador {
	private ArrayList<Administrador> administradors;
	private ControladorAdministradorDB dbController = new ControladorAdministradorDB();
	
	public ControladorAdministrador(){
		administradors = new ArrayList<Administrador>();
	}
	public Administrador getAdministrador(String username){
		Administrador admin = null;
		boolean stop = false;
		int size = administradors.size();
		for(int i = 0; i < size && !stop; ++i){
			if(administradors.get(i).getUsername().equals(username)){
				stop = true;
				admin = administradors.get(i);
			}
		}
		return admin;
	}
	
	public boolean Login(String username, String password){
	 return false;
	}
	
	public void crearAdministrador(){
		Administrador administrador = new Administrador("nombre", "apellido", "admin", "admin", "627835723");
		administradors.add(administrador);
		
		dbController.insertAdministrador(administrador);
	}
}
