import java.time.LocalDateTime;

public class TicketDeRecargaDeCelular extends Ticket {

	int numeroRecargado;
	
	public TicketDeRecargaDeCelular(String n, PuntoDeVenta p, LocalDateTime l, double m, int cel) {
		super(n, p, l, m);
		numeroRecargado = cel;
	}

	public int getNumeroRecargado() {
		return numeroRecargado;
	}

}
