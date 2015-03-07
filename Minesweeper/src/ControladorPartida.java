import java.util.ArrayList;


public class ControladorPartida {
	private ArrayList<Partida> partides;
	
	public ControladorPartida(){
		partides = new ArrayList<Partida>();
	}
	
	public Partida getPartida(Integer idPartida){
		Partida partida = new Partida();
		boolean stop = false;
		int size = partides.size();
		for(int i = 0; i < size && !stop; ++i){
			Partida aux = partides.get(i);
			if(aux.getIdPartida().equals(idPartida) ){
				stop = true;
				partida = partides.get(i);
			}
		}
		return partida;
	}
	
	public void addPartida(Partida partida){
		partides.add(partida);
	}
}
