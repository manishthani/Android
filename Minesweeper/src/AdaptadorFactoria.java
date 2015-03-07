
public class AdaptadorFactoria {
	private static AdaptadorFactoria adaptadorFactoria = new AdaptadorFactoria();
	private IAdaptadorMissatgeria adaptMissatgeria = new AdaptadorMissatgeria();
	
	public static AdaptadorFactoria getInstance(){
		return adaptadorFactoria;
	}

	public IAdaptadorMissatgeria getIAdaptMissatgeria() {
		return adaptMissatgeria;
	}
	
}
