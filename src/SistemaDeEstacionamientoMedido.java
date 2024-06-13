import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SistemaDeEstacionamientoMedido {

	private double precioPorHora;
	private LocalTime horaDeFinDeLaFranja;
	private List<Ticket>                ticketsDelSistema;
	private List<Infraccion>            infracciones;
	private List<Notificable>           notificados;
	private List<Estacionamiento>       estacionamientos;
	private List<AplicacionUsuario>     usuarios;
	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	
	 
	
	public SistemaDeEstacionamientoMedido() {
		precioPorHora = 40.00;
		horaDeFinDeLaFranja = LocalTime.of(20, 0);
		ticketsDelSistema = new ArrayList<Ticket>();
		infracciones = new ArrayList<Infraccion>();
		notificados = new ArrayList<Notificable>();
		estacionamientos = new ArrayList<Estacionamiento>();
		usuarios = new ArrayList<AplicacionUsuario>();
		zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	}
	
	public void cargarCelular(int numeroACargar, double monto) {
		
		Optional<AplicacionUsuario> usuario = usuarios.stream().filter(u -> u.getNumero() == numeroACargar).findFirst();
		
		if(usuario.isPresent()){
			usuario.get().cargarCredito(monto);
			notificarCargaDeCredito(usuario.get());
		}
	}
	
	public void registrarTicket(Ticket ticket) {
		ticketsDelSistema.add(ticket);
		
	}
	
	public List<Ticket> getTickets() {
		return this.ticketsDelSistema;
	}
	
	public void iniciarEstacionamiento(Estacionamiento e, AplicacionUsuario a){
		estacionamientos.add(e);
		notificarInicioDeEstacionamiento(a);
	}
	
	public void iniciarEstacionamiento(Estacionamiento e){
		estacionamientos.add(e);
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}

	public void registrarUsuario(AplicacionUsuario u) {
		usuarios.add(u);
	}
	
	public List<AplicacionUsuario> getUsuarios() {
		return this.usuarios;
	}
	
	public void registrarNuevaInfraccion(Infraccion i) {
		infracciones.add(i);
	}
	
	public List<Infraccion> getinfracciones() {
		return this.infracciones;
	}
	
	public boolean estaVigenteLaPatente(String p) {
		
		Optional<Estacionamiento> estacionamientoBuscado = estacionamientos.stream().filter(e -> e.getPatente().equals(p)).findFirst();
		
		if (estacionamientoBuscado.isPresent()){
			return estacionamientoBuscado.get().estaVigente();
		}
		return false; 
	}
	
	
	public void finalizarEstacionamiento(int telefono){
	AplicacionUsuario usuarioBuscado = usuarios.stream().filter(u -> u.getNumero() == telefono).findFirst().get();
    
    Estacionamiento estacionamientoDelUsuario = estacionamientos.stream().filter(e -> e.getPatente() == usuarioBuscado.getPatente()).findFirst().get();
    
    estacionamientoDelUsuario.setHoraFin(LocalTime.now());
    usuarioBuscado.cobrarMonto(montoParaElHorario(estacionamientoDelUsuario.getHoraInicio(), LocalTime.now()));
    
    notificarFinalizacionDeEstacionamiento(usuarioBuscado);
  
	}
    
	
	private void notificarFinalizacionDeEstacionamiento(AplicacionUsuario a) {
		notificados.stream().forEach(n -> n.inicioEstacionamiento(a));
	}
	
	
	private void notificarInicioDeEstacionamiento(AplicacionUsuario a) {
		notificados.stream().forEach(n -> n.finalizoEstacionamiento(a));
	}
	
	
	private void notificarCargaDeCredito(AplicacionUsuario a) {
		notificados.stream().forEach(n -> n.cargoCredito(a));
	}
	

	public void finalizarTodosLosEstacionamientos() {
		
		for (AplicacionUsuario usuario : usuarios){
			usuario.finalizarEstacionamiento();
       }
	}
	
	
	public void subscribirNotificado(Notificable n) {
		notificados.add(n);
	}
	
	
	public void desuscscribirNotificado(Notificable n) {
		notificados.remove(n);
	}
	
	
	public List<Notificable> getNotificados() {
		return this.notificados;
	}

	
	public double montoParaElHorario(LocalTime horaInicio, LocalTime horaFin) {
		
		return (horaFin.getHour() - horaInicio.getHour()) * precioPorHora;	
	}
	

	public LocalTime getHoraFinFranjaHoraria() {
		return horaDeFinDeLaFranja;
	}
	
	
	public void registrarNuevaZona(ZonaDeEstacionamiento z) {
		zonasDeEstacionamiento.add(z);
	}

	public List<ZonaDeEstacionamiento> getZonasRegistradas() {
		return this.zonasDeEstacionamiento;
	}
	
}
