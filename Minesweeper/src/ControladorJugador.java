import java.util.ArrayList;


public class ControladorJugador {
	private ArrayList<Jugador> jugadors;
	private ControladorJugadorDB dbController = new ControladorJugadorDB();
	public ControladorJugador(){
		jugadors = new ArrayList<Jugador>();
	}
	
	public Jugador getJugador(String username){
		Jugador jugador  = null;
		boolean stop = false;
		int size = jugadors.size();
		for(int i = 0; i < size && !stop; ++i){
			Jugador aux = jugadors.get(i);
			if(aux.getUsername().equals(username)){
				if(aux.getEmail() != null){
					jugador = jugadors.get(i);
				}
			}
		}
		return jugador;
	}
	
	public void crearJugador(){
		Jugador jugador = new Jugador("nombre", "apellido", "user", "user", "manish.thani@gmail.com");
		jugadors.add(jugador);
		
		dbController.insertJugador(jugador);
	}
	
}
