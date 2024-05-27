import java.time.LocalDateTime;

public class TicketDeRecargaDeCelular extends Ticket {

	int numeroRecargado;
	
	public TicketDeRecargaDeCelular(PuntoDeVenta p, LocalDateTime l, double m, int cel) {
		super(p, l, m);
		numeroRecargado = cel;
	}

	public int getNumeroRecargado() {
		return numeroRecargado;
	}

}
