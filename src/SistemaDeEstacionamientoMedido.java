import java.util.Iterator;
import java.util.List;

public class SistemaDeEstacionamientoMedido {
	/*atributos en si*/
	
	/*conoce a*/
	private List<Ticket>                ticketsDelSistema;
	private List<Infraccion>            infracciones;
	private List<Notificable>           notificados;
	private List<Estacionamiento>       estacionamientos;
	private List<AplicacionUsuario>     usuarios;
	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	
	
	
	
	public SistemaDeEstacionamientoMedido() {
		
	}
	
	public void cargarCelular(int numeroACargar, double monto) {
		int i = 0;
		while (i < usuarios.size()) {
	        AplicacionUsuario usuario = usuarios.get(i);
	        if (usuario.getNumero() == numeroACargar)
	        {
	            usuario.cargarCredito(monto);
	        }
	        i++;
	    }		
	}
	
	
	public void registrarTicket(Ticket ticket) {
		ticketsDelSistema.add(ticket);
		
	}
	public void registarEstacionamiento(Estacionamiento e) {
		estacionamientos.add(e);
	}
	public void registrarUsuario(AplicacionUsuario u) {
		usuarios.add(u);
	}
	
	public void registrarInfraccion(Infraccion i) {
		infracciones.add(i);
	}
	
	
	
	
	
	public void finalizarEstacionamiento(int telefono) {
		/*establecer todas las acciones que realiza*/
	}
	
	
	
	
	
	
	
	public void finalizarTodosLosEstacionamientos() {
		for (Estacionamiento estacionamiento : estacionamientos){
			int telefono = telefonoDelEstacionamiento(estacionamiento.getPatente());
			
			finalizarEstacionamiento(telefono);
			
			/*ver donde mas tengo que actualizar
			 *ticket
			 *zona
			 *etc    */
            	
       }
	}

	
	
	
	
	
	public boolean seEncuentraVigente(String pantente) {
		int i = 0;
		while (i < estacionamientos.size()) {
	        Estacionamiento estacionamiento = estacionamientos.get(i);
	        if (estacionamiento.getPatente() == patente)
	        {
	            return estacionamiento.isEstaVigente();
	        }
	        i++; /*estoy seguro que se encuentra en la lista, el return corta*/
		}
	}
	
	
	
	
	
	
	public void subscribirNotificado(Notificable n) {
		
	}
	
	
	
	
	
	
	public void desubscribirNotificado(Notificable n) {
		
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
	
	
	
	
	
	
	
	

	
}
