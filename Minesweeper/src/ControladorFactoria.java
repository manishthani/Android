
public class ControladorFactoria {
	private static ControladorFactoria controladorFactoria = new ControladorFactoria(); 
	
	private ControladorAdministrador ctrlAdministrador;
	private ControladorCasella ctrlCasella;
	private ControladorJugador ctrlJugador;
	private ControladorNivell ctrlNivell;
	private ControladorPartida ctrlPartida;
	private ControladorUsuariRegistrat ctrlUsuariRegistrat;
	
	
	private ControladorFactoria(){
		//Se tiene que Inicializar controladores o no
		ctrlAdministrador = new ControladorAdministrador();
		ctrlCasella = new ControladorCasella();
		ctrlJugador = new ControladorJugador();
		ctrlNivell = new ControladorNivell();
		ctrlPartida = new ControladorPartida();
		ctrlUsuariRegistrat = new ControladorUsuariRegistrat();
	}
	
	public static ControladorFactoria getInstance(){
		return controladorFactoria;
	}

	public static ControladorFactoria getCtrlFactoria() {
		return controladorFactoria;
	}

	public static void setCtrlFactoria(ControladorFactoria controladorFactoria) {
		ControladorFactoria.controladorFactoria = controladorFactoria;
	}

	public ControladorAdministrador getCtrlAdministrador() {
		return ctrlAdministrador;
	}

	public void setCtrlAdministrador(ControladorAdministrador ctrlAdministrador) {
		this.ctrlAdministrador = ctrlAdministrador;
	}

	public ControladorCasella getCtrlCasella() {
		return ctrlCasella;
	}

	public void setCtrlCasella(ControladorCasella ctrlCasella) {
		this.ctrlCasella = ctrlCasella;
	}

	public ControladorJugador getCtrlJugador() {
		return ctrlJugador;
	}

	public void setCtrlJugador(ControladorJugador ctrlJugador) {
		this.ctrlJugador = ctrlJugador;
	}

	public ControladorNivell getCtrlNivell() {
		return ctrlNivell;
	}

	public void setCtrlNivell(ControladorNivell ctrlNivell) {
		this.ctrlNivell = ctrlNivell;
	}

	public ControladorPartida getCtrlPartida() {
		return ctrlPartida;
	}

	public void setCtrlPartida(ControladorPartida ctrlPartida) {
		this.ctrlPartida = ctrlPartida;
	}

	public ControladorUsuariRegistrat getCtrlUsuariRegistrat() {
		return ctrlUsuariRegistrat;
	}

	public void setCtrlUsuariRegistrat(ControladorUsuariRegistrat ctrlUsuariRegistrat) {
		this.ctrlUsuariRegistrat = ctrlUsuariRegistrat;
	}
	
	
	
}
