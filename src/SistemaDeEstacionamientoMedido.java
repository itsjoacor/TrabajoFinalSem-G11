import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SistemaDeEstacionamientoMedido {

	private double precioPorHora;
	private LocalTime horaDeFinDeLaFranja;
	private List<Ticket>                ticketsDelSistema;
	private List<Infraccion>            infracciones;
	private List<Notificable>           notificados; //interfaz falta implementar
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
		
		usuarios.stream().filter(u -> u.getNumero() == numeroACargar).findFirst().ifPresent(u -> u.cargarCredito(monto));
	}
	
	
	public void registrarTicket(Ticket ticket) {
		ticketsDelSistema.add(ticket);
		
	}
	
	public void registarEstacionamiento(Estacionamiento e){
		estacionamientos.add(e);
	}
	
	public void registrarUsuario(AplicacionUsuario u) {
		usuarios.add(u);
	}
	
	public void registrarInfraccion(Infraccion i) {
		infracciones.add(i);
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
    usuarioBuscado.cobrarMonto(montoACobrar);
        
    estacionamientoDelUsuario.darDeBaja();
    }
    
	
	
	public void finalizarTodosLosEstacionamientos() {
		// finalizarTodosLosEst()
		// finalizarTodosLosUsuarios()  puede ser algo asi tambien y mas lindo
		for (AplicacionUsuario usuario : usuarios){
			
			usuario.finalizarEstacionamiento();
			
			/*Fijarse que hace 2 busquedas una locura
			 * 
			 * ver donde mas tengo que actualizar
			 *ticket queda   */
            	
       }
	}

	
	
	
	
	
	public boolean seEncuentraVigente(String patente) {
		Optional<Estacionamiento> estacionamiento = estacionamientos.stream()
                .filter(e -> e.getPatente()== patente)
                .findFirst();
		
		if (estacionamiento.isEmpty()) {
			return false;
		}
			return estacionamiento.get().estaVigente();
		
	}
	

	public void nuevaInfraccion(Infraccion inf){
		
		infracciones.add(inf);
	}
	
	
	

	public void subscribirNotificado(Notificable n) {
		
		
	}
	

	
	public void desuscscribirNotificado(Notificable n) {

	}
	
	
	public int telefonoDelEstacionamiento(String patente) {
		int i = 0;
		while (i < usuarios.size()) {
	        AplicacionUsuario usuario = usuarios.get(i);
	        if (usuario.getPatente() == patente)
	        {
	            return usuario.getNumero();
	        }
	        i++; /*estoy seguro que se encuentra en la lista, el return corta*/
		}
		
	}

	public double valorParaEstaCantidadDeHoras(int cantidadDeHoras) {
		
		return cantidadDeHoras * precioPorHora;
	}

	public LocalTime getHoraFinFranjaHoraria() {
		return horaDeFinDeLaFranja;
	}
	
}
