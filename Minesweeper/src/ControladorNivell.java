import java.util.ArrayList;


public class ControladorNivell {
	private ArrayList<Nivell> nivells;
	private ControladorNivellDB dbController = new ControladorNivellDB();
	
	public ControladorNivell(){
		nivells = new ArrayList<Nivell>();
	}
	public Nivell getNivell(String nom){
		Nivell nivell = new Nivell();
		boolean stop = false;
		int size = nivells.size();
		for(int i = 0; i < size && !stop; ++i){
			Nivell aux = nivells.get(i);
			if(aux.getNom().equals(nom) ){
				stop = true;
				nivell = nivells.get(i);
			}
		}
		return nivell;
		
	}
	
	public ArrayList<Nivell> getAll(){
		ControladorNivellDB ctrlNivellDB = new ControladorNivellDB();
		ArrayList<Nivell> nivells = ctrlNivellDB.getAll();
		return nivells;
	}
	
	public void crearNiveles(){
		Nivell nivel = new Nivell("Facil", 8,8, 10);
		nivells.add(nivel);
		dbController.insertNivell(nivel);
		
		nivel = new Nivell("Normal", 16, 16, 40);
		nivells.add(nivel);
		dbController.insertNivell(nivel);
		
		nivel = new Nivell("Dificil", 30, 30, 99);
		nivells.add(nivel);
		dbController.insertNivell(nivel);
		
	}
}
