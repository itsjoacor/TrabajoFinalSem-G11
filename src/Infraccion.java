import java.time.LocalDate;
import java.time.LocalTime;

public class Infraccion {
	private String                patente;
	private LocalDate             fechaEmision;
	private LocalTime             horaEmision;	
	private int                   inspectorID;
	private ZonaDeEstacionamiento zona;
	
	
	public Infraccion(String p, LocalDate fecha, LocalTime hora, int i, ZonaDeEstacionamiento z) {
		patente      = p;
		fechaEmision = fecha;
		horaEmision  = hora;
		inspectorID  = i;
		zona         = z;
	}


	public String getPatente() {
		return patente;
	}


	public LocalDate getFechaEmision() {
		return fechaEmision;
	}


	public LocalTime getHoraEmision() {
		return horaEmision;
	}


	public int getInspectorID() {
		return inspectorID;
	}


	public ZonaDeEstacionamiento getZona() {
		return zona;
	}
	
	
}
