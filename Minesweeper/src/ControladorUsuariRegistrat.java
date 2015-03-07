import java.util.ArrayList;


public class ControladorUsuariRegistrat {
	private ArrayList<UsuariRegistrat> usuarisRegistrats;
	
	public ControladorUsuariRegistrat(){
		usuarisRegistrats = new ArrayList<UsuariRegistrat>();
	}
	public UsuariRegistrat getUsuariRegistrat(String username){
		UsuariRegistrat usuari = new UsuariRegistrat();
		boolean stop = false;
		int size = usuarisRegistrats.size();
		for(int i = 0; i < size && !stop; ++i){
			UsuariRegistrat aux = usuarisRegistrats.get(i);
			
			if(aux.getUsername().equals(username) ){
				usuari = usuarisRegistrats.get(i);
			}
		}
		return usuari;
	}
	
}
