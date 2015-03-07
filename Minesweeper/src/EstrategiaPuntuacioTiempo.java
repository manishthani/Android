
public class EstrategiaPuntuacioTiempo implements IEstrategiaPuntuacio {
	private static final Long MAXTIME = (long) 600000; // En segundos
	public Integer calcularPuntuacio(Partida partida) {
 
		Long initTime = ControladorCasoDeUsoJugarPartida.initTime;
		Long endTime = System.currentTimeMillis();
		Long result = (MAXTIME - (endTime - initTime));
		
		System.out.println(endTime + "<- ENDTIME");
		System.out.println(initTime + "<- INITTIME");
		System.out.println(endTime - initTime + "<- TIEMPO" );
		return (result.intValue() / 1000);
	}
}
