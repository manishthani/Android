
public class ServiceLocator {
	private static ServiceLocator serviceLocator = new ServiceLocator();
	private svMissatgeria serveiMissatgeria = new svMissatgeria();
	
	public static ServiceLocator getInstance(){
		return serviceLocator;
	}

	//Se tiene que arreglar esta operacion
	public svMissatgeria find(String nomServei){
		//Connexio amb el servidor...
		return serveiMissatgeria;
	}
	
}
