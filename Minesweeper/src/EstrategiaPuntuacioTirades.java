
public class EstrategiaPuntuacioTirades implements IEstrategiaPuntuacio{
	private static final int MAXTIRADES = 1000;
	
	public Integer calcularPuntuacio(Partida partida) {
		int nombreTirades = partida.getNombreTirades();
		return ( (MAXTIRADES - nombreTirades > 0) ? MAXTIRADES - nombreTirades : 0);
	}
}
