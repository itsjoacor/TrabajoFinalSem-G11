import java.time.LocalDateTime;

public abstract class Ticket {
	
	private int nroTicket; 
	private PuntoDeVenta puntoDeEmision;
	private LocalDateTime fechayHoraDeEmision;
	private double montoFinal;
	
	
	public Ticket(PuntoDeVenta p, LocalDateTime l, double m) {
		
		puntoDeEmision = p;
		fechayHoraDeEmision = l;
		montoFinal = m;
	}


	public int getNroTicket() {
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
