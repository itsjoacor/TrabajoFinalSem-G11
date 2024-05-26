import java.time.LocalDateTime;

public abstract class Ticket {
	
	private String nroTicket; 
	private PuntoDeVenta puntoDeEmision;
	private LocalDateTime fechayHoraDeEmision;
	private double montoFinal;
	
	
	public Ticket(String n, PuntoDeVenta p, LocalDateTime l, double m) {
		
		nroTicket = n;
		puntoDeEmision = p;
		fechayHoraDeEmision = l;
		montoFinal = m;
	}
	
	
}
