import java.time.LocalDateTime;

public class TicketDeHoras extends Ticket {

	int cantidadDeHoraCompradas;
	
	
	public TicketDeHoras(PuntoDeVenta p, LocalDateTime l, double m, int c) {
		super(p, l, m);
		cantidadDeHoraCompradas = c;
	}


	public int getCantidadDeHoraCompradas() {
		return cantidadDeHoraCompradas;
	}

}
