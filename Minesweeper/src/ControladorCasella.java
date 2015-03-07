import java.util.ArrayList;

public class ControladorCasella {
	private ArrayList<Casella> caselles;
	
	public ControladorCasella(){
		caselles = new ArrayList<Casella>();
	}
	
	public Casella getCasella(Integer idPartida, Integer numeroFila , Integer numeroColumna){
		Casella casella = new Casella();
		boolean stop = false;
		int size = caselles.size();
		for(int i = 0; i < size && !stop; ++i){
			Casella aux = caselles.get(i);
			if(aux.getIdPartida().equals(idPartida) && aux.getNumeroFila().equals(numeroFila) && aux.getNumeroColumna().equals(numeroColumna)){
				stop = true;
				casella = caselles.get(i);
			}
		}
		return casella;
	}
}
