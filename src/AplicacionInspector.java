import java.time.LocalDate;
import java.time.LocalTime;

public class AplicacionInspector extends AplicacionSEM {
	
	private int idInspector;
	private ZonaDeEstacionamiento zona;
	
	public AplicacionInspector(SistemaDeEstacionamientoMedido s, int id, ZonaDeEstacionamiento zonaEst) {			
		super(s);
		idInspector = id;
		zona = zonaEst;
	}
	
	
	public void consultarEstacionamiento(String patente){
		
		if(!sistema.estaVigenteLaPatente(patente)) {
			emitirInfraccion(patente);
		}
	}
	
	private void emitirInfraccion(String patente){
			Infraccion infraccionACargar = new Infraccion(patente, LocalDate.now(), LocalTime.now(),idInspector, zona);
			sistema.registrarNuevaInfraccion(infraccionACargar);
	}


	public int getInspectorId() {
		// TODO Auto-generated method stub
		return idInspector;
	}	
	
	public ZonaDeEstacionamiento getZonaDelInspector() {
		return zona;
	}
	
	
}

