import java.time.LocalTime;

public class EstacionamientoMedianteApp extends Estacionamiento{
	
	private int numeroDeCelular;
	
	public EstacionamientoMedianteApp(String p, LocalTime hi, LocalTime hf, int n) {
		super(p, hi, hf);
		numeroDeCelular = n;
	}

	public int getNumeroDeCelular() {
		return numeroDeCelular;
	}

}
