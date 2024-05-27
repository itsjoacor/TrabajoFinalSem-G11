import java.time.LocalTime;

public class EstacionamientoPorCompraPuntual extends Estacionamiento{
	
	private int cantidadDeHorasCompradas;
	
	public EstacionamientoPorCompraPuntual(String p, LocalTime hi, LocalTime hf, int c) {
		super(p, hi, hf);
		cantidadDeHorasCompradas = c;
	}

	public int getCantidadDeHorasCompradas() {
		return cantidadDeHorasCompradas;
	}

}
