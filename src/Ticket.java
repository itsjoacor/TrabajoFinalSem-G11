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


	public String getNroTicket() {
		return nroTicket;
	}


	public PuntoDeVenta getPuntoDeEmision() {
		return puntoDeEmision;
	}


	public LocalDateTime getFechayHoraDeEmision() {
		return fechayHoraDeEmision;
	}


	public double getMontoFinal() {
		return montoFinal;
	}
	
}
