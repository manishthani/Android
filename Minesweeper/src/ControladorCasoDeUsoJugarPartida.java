import java.util.ArrayList;


public class ControladorCasoDeUsoJugarPartida {
	ControladorCasoDeUsoLogin ctrlLogin;
	ControladorCasoDeUsoConsultarNivell ctrlConsultarNivell;
	public static Long initTime = 0L; 
	//Post: Se almacena en capa de dominio el Jugador
	Jugador jugador ;
	Partida partida ;
	public ControladorCasoDeUsoJugarPartida(){
		ctrlLogin = new ControladorCasoDeUsoLogin();
		ctrlConsultarNivell = new ControladorCasoDeUsoConsultarNivell();
	}
	
	public void Login(String userN, String passwd) throws Exception{
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorJugador ctrlJugador = ctrlFactoria.getCtrlJugador();
		
		
		ControladorAdministrador ctrlAdministrador = ctrlFactoria.getCtrlAdministrador();
		//Creamos jugador y insertamos en la base de datos (Hibernate)
		ctrlJugador.crearJugador();
		jugador = ctrlJugador.getJugador(userN);
		//Creamos admin y insertamos en la base de datos (Hibernate)
		ctrlAdministrador.crearAdministrador();
		Administrador admin = ctrlAdministrador.getAdministrador(userN);
	
		//Excepciones del contrato
		if(jugador == null && admin == null) throw new Exception("UsuariNoExisteix");
		if((jugador != null && !jugador.getPwd().equals(passwd)) || (admin != null && !admin.getPwd().equals(passwd)) ) throw new Exception("PasswordIncorrecte");
		if(admin != null) throw new Exception ("UsuariNoJugador");
		ctrlLogin = new ControladorCasoDeUsoLogin(userN, passwd);
		
		Boolean correcte = ctrlLogin.login(); //Devuelve true por defecto
		jugador = (Jugador) ctrlJugador.getJugador(userN);
		if(jugador == null) throw new Exception("UsuariNoJugador" + userN + " " + passwd +" jugador == null");	
	}
	
	public ArrayList<Nivell> consultarNivell() throws Exception{
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorNivell ctrlNivell = ctrlFactoria.getCtrlNivell();
		
		//Creamos niveles y insertamos en la base de datos (Hibernate)
		ctrlNivell.crearNiveles();
		ctrlConsultarNivell = new ControladorCasoDeUsoConsultarNivell();
		
		ArrayList<Nivell> list = ctrlNivell.getAll();
		//Excepcion del contrato
		if(list.size() == 0) throw new Exception("NoHiHaNivells");
		return list;
	}
	
	
	
	public void desmarcarCasella(Integer numF, Integer numC) throws Exception{
		System.out.println(numF + " " + numC);
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorCasella ctrlCasella = ctrlFactoria.getCtrlCasella();
		ControladorPartida ctrlPartida = ctrlFactoria.getCtrlPartida();
		Casella casella = ctrlPartida.getPartida(BuscaMines.getInstance().getIdPartida()).getCasellaAtIndex(numF, numC);
		
		//Controlar Excepciones del contrato
		if(!casella.getEstaMarcada()) throw new Exception("CasellaNoMarcada ");
		if(casella.getEstaDescoberta()) throw new Exception("CasellaJaDescoberta");
		casella.setEstaMarcada(false);
	}
	
	public void marcarCasella(Integer numF, Integer numC) throws Exception{
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorCasella ctrlCasella = ctrlFactoria.getCtrlCasella();
		ControladorPartida ctrlPartida = ctrlFactoria.getCtrlPartida();
		Casella casella = ctrlPartida.getPartida(BuscaMines.getInstance().getIdPartida()).getCasellaAtIndex(numF, numC);
		
		//Controlar Excepciones del contrato
		if(casella.getEstaMarcada()) throw new Exception("CasellaJaMarcada");
		if(casella.getEstaDescoberta()) throw new Exception("CasellaJaDescoberta");
		casella.setEstaMarcada(true);
		 System.out.println(casella.getEstaMarcada() + "<-CasillaMarcarDominio");
	}
	
	
	public Resultado descobrirCasella(Integer numF, Integer numC) throws Exception{
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorCasella ctrlCasella = ctrlFactoria.getCtrlCasella();
		ControladorPartida ctrlPartida = ctrlFactoria.getCtrlPartida();
		
		
		Partida partida = ctrlPartida.getPartida(BuscaMines.getInstance().getIdPartida());
		Casella casella = ctrlPartida.getPartida(partida.getIdPartida()).getCasellaAtIndex(numF, numC);
		//Excepciones del contrato
		
		if(casella.getEstaDescoberta()) throw new Exception("CasellaJaDescoberta " + casella.getNumeroColumna() + " "  + casella.getNumeroColumna() + " " +casella.getTeMina());
		if(casella.getEstaMarcada()) throw new Exception("CasellaJaMarcada");
		
		Integer puntuacio = 0;
		//Post: CasellaDescoberta
		casella.setEstaDescoberta(true); 
		partida.setNombreTirades(partida.getNombreTirades() + 1);
		
		//Casillas de la Fila Inferior
		if(casella.getNumero() == 0) {
			if(numF + 1 < partida.getCaselles().length) {
				Casella aux = partida.getCasellaAtIndex(numF + 1, numC);
				if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF+1, numC);
				
				if(numC + 1 < partida.getCaselles()[0].length) {
					aux = partida.getCasellaAtIndex(numF+1, numC+1);
					if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF + 1, numC+1);
				}
				if(numC - 1 >= 0 ){
					aux = partida.getCasellaAtIndex(numF+1, numC - 1);
					if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF + 1, numC - 1);
				}
			}
			//Casillas de la Fila superior
			if(numF - 1 >= 0) {
				Casella aux = partida.getCasellaAtIndex(numF - 1, numC);
				if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF-1, numC);
				
				if(numC + 1 < partida.getCaselles()[0].length) {
					aux = partida.getCasellaAtIndex(numF-1, numC + 1);
					if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF - 1, numC+1);
				}
				if(numC - 1 >= 0 ){
					aux = partida.getCasellaAtIndex(numF-1, numC - 1);
					if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF - 1, numC - 1);
				}
			}
			//Casillas a la derecha y izquierda
			if(numC + 1 < partida.getCaselles()[0].length) {
				Casella aux = partida.getCasellaAtIndex(numF, numC + 1);
				if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF , numC + 1);
			}
			if(numC - 1 >= 0) {
				Casella aux = partida.getCasellaAtIndex(numF, numC - 1);
				if(!aux.getEstaDescoberta() && !aux.getEstaMarcada()) descobrirCasella(numF , numC - 1);
			}
		}
		//Post: comprovaPartidaPerduda
		if(casella.getTeMina()) {
			partida.setEstaAcabada(true);
			//post partidaJugada
			/*jugador.addPartidaJugada(partida);
			partida.setJugadorPartidaJugada(jugador);
			
			jugador.setPartidaActual(null);
			partida.setJugadorPartidaActual(null);*/
			
		}
		else {
			
			boolean totesDescobertes = false;
			if(partida.getCaselles().length * partida.getCaselles().length - partida.getNivell().getNombreMines() == partida.getNombreTirades()) totesDescobertes = true;
			if(totesDescobertes){
				//Post: comprovaPartidaGuanyada
				partida.setEstaAcabada(true);
				partida.setEstaGuanyada(true);
				
				//Calcular primero puntuacion dependiendo de la e strategia que se escogio de forma aleatoria. (Patron Estrategia)
				puntuacio = partida.calcularPuntuacio();
				
				//post partidaJugada
				
				jugador.addPartidaJugada(partida);
				partida.setJugadorPartidaJugada(jugador);
				jugador.setPartidaActual(null);
				partida.setJugadorPartidaActual(null);
				
				//Se llama a servicio de mensajeria para enviarMissatge()
				AdaptadorFactoria adaptadorFactoria = AdaptadorFactoria.getInstance();
				IAdaptadorMissatgeria IAdaptador = adaptadorFactoria.getIAdaptMissatgeria();
				IAdaptador.enviarMissatge(jugador.getEmail() + " " + partida.getIdPartida() + " " + puntuacio ); //Se envia ID y puntuacion
			}
			
		}
		//System.out.println(casella.getNumeroFila() + " " + casella.getNumeroColumna() + " " + casella.getEstaMarcada() + " "+ casella.getEstaDescoberta());
		
		//post result
		Resultado result = new Resultado();
		result.setEstaAcabada(partida.getEstaAcabada());
		result.setEstaGuanyada(partida.getEstaGuanyada());
		if(partida.getEstaGuanyada()) result.setPuntuacio(puntuacio); 
		return result;
	}
	
	
	public void CrearPartida(String nomNivell){
		//Incrementamos id de Partida
		BuscaMines.getInstance().incrementarIdPartida();
		int idPartida = BuscaMines.getInstance().getIdPartida();
		//Creamos Partida con una estrategia de puntuacion random y inicializamos como dice enunciado
		partida = new Partida(idPartida,false,false, 0);
		initTime = System.currentTimeMillis();
		//Asignamos Nivell
		ControladorFactoria ctrlFactoria = ControladorFactoria.getInstance();
		ControladorNivell ctrlNivell = ctrlFactoria.getCtrlNivell();
		ControladorPartida ctrlPartida = ctrlFactoria.getCtrlPartida();
		
		Nivell nivell = ctrlNivell.getNivell(nomNivell);
		partida.setNivell(nivell);
		
		//Creamos NumeroXFila x NumeroXColumna segun el nivel y inicializamos minas a falso
		int n = nivell.getNombreCasellesXFila();
		int m = nivell.getNombreCasellesXFila();
		int nombreMines = nivell.getNombreMines();
		
		partida.createCaselles(n, m);
		for(int i = 1; i <= n ; ++i){
			for(int j = 1; j <= m; ++j){
				Casella casella = new Casella(partida.getIdPartida(), i-1,j-1,false,false,false);
				partida.setCasellaAtIndex(casella, i-1, j-1);
			}
		}
		
		//Ponemos [nombreMines] minas en la matriz y ponemos numero a sus vecinos, y cada mina le ponemos numero = -1 (no tiene numero)
		int count = 0; 
		while (count < nombreMines) {
		    int i = (int)(Math.random() * nivell.getNombreCasellesXFila() + 1); //Genera numero aleatorio entre 1...nombreCaselles
		    int j = (int)(Math.random() * nivell.getNombreCasellesXColumna() + 1);
		    if (!partida.getCaselles()[i-1][j-1].getTeMina()) {
		        ++count;
		        partida.getCaselles()[i-1][j-1].setTeMina(true);
		        partida.getCaselles()[i-1][j-1].setNumero(-99); //Una casilla que tiene mina no tiene numero (asignamos -99 que significa invalido)
		        partida.incrementarNumeroCasellesVeines(i-1,j-1);
		    }
		}
		//Asignamos jugador
		partida.setJugadorPartidaActual(jugador);
		jugador.setPartidaActual(partida);
		ctrlPartida.addPartida(partida);
	}
	
	public Casella[][] getCaselles(){
		return partida.getCaselles();
	}
	
}
