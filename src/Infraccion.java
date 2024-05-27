import java.time.LocalDate;

public class Infraccion {
	private String                patente;
	private LocalDate             fyhEmision;
	private Inspector             inspector;
	private ZonaDeEstacionamiento zona;
	
	
	public Infraccion(String p, LocalDate fyh, Inspector i, ZonaDeEstacionamiento z) {
		patente    = p;
		fyhEmision = fyh;
		inspector  = i;
		zona       = z;
	}
	
	
}
