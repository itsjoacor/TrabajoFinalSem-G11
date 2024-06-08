import java.time.LocalDateTime;
import java.time.LocalTime;

public class PuntoDeVenta {

	private ZonaDeEstacionamiento zonaDelPunto;
	private SistemaDeEstacionamientoMedido sistema;
	
	public PuntoDeVenta(ZonaDeEstacionamiento z, SistemaDeEstacionamientoMedido s) {
		zonaDelPunto = z;
		sistema = s;
	}

	public ZonaDeEstacionamiento getZonaDelPunto() {
		return zonaDelPunto;
	}

	public SistemaDeEstacionamientoMedido getSistema() {
		return sistema;
	}
	
	
	public void registrarEstacionamiento(String patente, int cantidadDeHoras) {
		
		EstacionamientoPorCompraPuntual nuevoEstacionamiento = creacionDeEstacionamiento(patente, cantidadDeHoras);
		TicketDeHoras nuevoTicket = creacionDeTicketDeHoras(cantidadDeHoras);
		
		
		sistema.iniciarEstacionamiento(nuevoEstacionamiento);
		sistema.registrarTicket(nuevoTicket);
		
	}

	private TicketDeHoras creacionDeTicketDeHoras(int cantidadDeHoras) {
		LocalDateTime horaYFechaActual = LocalDateTime.now();
		double montoTotal = cantidadDeHoras * 40;
		TicketDeHoras nuevoTicket = new TicketDeHoras(this, horaYFechaActual, montoTotal, cantidadDeHoras);
		return nuevoTicket;
	}

	private EstacionamientoPorCompraPuntual creacionDeEstacionamiento(String patente, int cantidadDeHoras) {
		EstacionamientoPorCompraPuntual nuevoEstacionamiento;
		LocalTime horaActual = LocalTime.now();
		LocalTime horaFinalizacion = horaActual.plusHours(cantidadDeHoras);
		nuevoEstacionamiento = new EstacionamientoPorCompraPuntual(patente, horaActual, horaFinalizacion, cantidadDeHoras);
		return nuevoEstacionamiento;
	}
	
	
	public void cargarCelular(int numero, double monto) {
		
		sistema.cargarCelular(numero, monto);
		
	}
	
	
	
}
