import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SistemaDeEstacionamientoMedido {
	/*atributos en si*/
	
	/*conoce a*/
	private List<Ticket>                ticketsDelSistema;
	private List<Infraccion>            infracciones;
	private List<Notificable>           notificados; //interfaz falta implementar
	private List<Estacionamiento>       estacionamientos;
	private List<AplicacionUsuario>     usuarios;
	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	
	 
	
	public SistemaDeEstacionamientoMedido() {
		
	}
	
	public void cargarCelular(int numeroACargar, double monto) {
		int i = 0;
		while (i < usuarios.size()) {
	        AplicacionUsuario usuario = usuarios.get(i); //el usuario es instancia de aplicacionUsuario
	        if (usuario.getNumero() == numeroACargar)
	        {
	            usuario.cargarCredito(monto);
	            break;
	        }
	        i++;
	    }		// lo busca en la lista de usuarios y le carga credito, actualizandolo
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
		
		if (!estacionamientoBuscado.isEmpty()){
			return estacionamientoBuscado.get().estaVigente();
		}
		return false; 
	}
	
	
	public void finalizarEstacionamiento(int telefono){
		Optional<AplicacionUsuario> usuarioBuscado = usuarios.stream()
		                                            .filter(u -> u.getNumero() == telefono)
				                                    .findFirst();
		
		Optional<Estacionamiento> estacionamientoDelUsuario = estacionamientos.stream()
                                                              .filter(e -> e.getPatente()== usuarioBuscado.getPatente())
                                                              .findFirst();
		if (usuarioBuscado.isEmpty())
		{
			//el usuario no esta, no hago nada
		}
			double montoACobrar = estacionamientoDelUsuario.get().montoACobrar();
			usuarioBuscado.get().cobrarMonto(montoACobrar);
			
			estacionamientoDelUsuario.get().darDeBaja();
			usuarioBuscado.get().cambiarDeEstado();
				//si quiero desde el sem finalizar todo, para no tener que setearle un estado, como lo impletente?
							//le digo al usuario que finalice y ahi como los estados se conocen se puede relaizar
		    //estadoUsuarioEstacionamiento -> false  FIJARSE ENCAPSULAMIENTO

		
		
		int i = 0;
		while (i < usuarios.size()){
	        AplicacionUsuario usuario = usuarios.get(i);
	        if (usuario.getNumero() == telefono)
	        {
	            usuario.cobrarMonto(montoACobrar);//ver que onda el negativo
	            //usuario.setEstado(objeto o pastel); //ver como implementarlo si es estado.
	            break;
	        }
	        i++;
	    }
		
	}
	
	
	
	
	//Entre estos dos ver que onda, ya que u
	
	
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
	
	
	
	
	
	
	public void desuSbscribirNotificado(Notificable n) {
		
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
