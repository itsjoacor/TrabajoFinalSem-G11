import java.time.LocalDate;
import java.time.LocalTime;

public class AplicacionInspector extends AplicacionSEM {
	
	private int idInspector;
	private ZonaDeEstacionamiento zona;
	
	public AplicacionInspector(int id, ZonaDeEstacionamiento zonaEst) {
					
		super();
		idInspector = id;
		zona = zonaEst;
	}
	
	
	public boolean consultarEstacionamiento(String patente){
		
		return sistema.estaVigenteLaPatente(patente);
		
	}
	
	public void emitirInfraccion(String patente){
		
		if (!consultarEstacionamiento(patente)){
			Infraccion infraccionACargar = new Infraccion(patente, LocalDate.now(), LocalTime.now(),idInspector, zona);
			sistema.nuevaInfraccion(infraccionACargar);
		}
	}	
	
	
}

