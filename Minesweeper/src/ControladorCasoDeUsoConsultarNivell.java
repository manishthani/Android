import java.util.ArrayList;


public class ControladorCasoDeUsoConsultarNivell {
	public ControladorCasoDeUsoConsultarNivell(){}
	
	public ArrayList<Nivell> consultarNivell() {
		
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorNivell ctrlNivell = ctrlFactoria.getCtrlNivell();
		
		return ctrlNivell.getAll();
	}
	
}
