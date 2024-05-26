import java.util.ArrayList;
import java.util.List;

public class ZonaDeEstacionamiento {

	private List<PuntoDeVenta> puntosDeVentaDeLaZona; 
	private AplicacionInspector inspector;
	
	public ZonaDeEstacionamiento(AplicacionInspector i) {
		inspector = i;
		puntosDeVentaDeLaZona = new ArrayList<PuntoDeVenta>();
	}
	
	public void registrarPuntoDeVenta(PuntoDeVenta p) {
		
		puntosDeVentaDeLaZona.add(p);
	}

	public AplicacionInspector getInspector() {
		return inspector;
	}

	public List<PuntoDeVenta> getPuntosDeVentaDeLaZona() {
		return puntosDeVentaDeLaZona;
	}
	
}
