import java.time.LocalDateTime;

public class TicketDeHoras extends Ticket {

	int cantidadDeHoraCompradas;
	
	
	public TicketDeHoras(String n, PuntoDeVenta p, LocalDateTime l, double m, int c) {
		super(n, p, l, m);
		cantidadDeHoraCompradas = c;
	}


	public int getCantidadDeHoraCompradas() {
		return cantidadDeHoraCompradas;
	}

}
