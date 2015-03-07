
public class AdaptadorMissatgeria implements IAdaptadorMissatgeria {
	public void enviarMissatge(String missatge){

		ServiceLocator locator = ServiceLocator.getInstance();
		svMissatgeria servei = locator.find("svMissatgeria");
		servei.enviarMissatge(missatge);
		
	}
}
