import client.Client;


public class svMissatgeria {

	public static void enviarMissatge(String missatge){
		Client c = new Client();
		c.enviarMissatgeclient(missatge);
	}
}
