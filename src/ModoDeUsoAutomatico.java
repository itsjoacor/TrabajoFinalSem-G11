
public class ModoDeUsoAutomatico implements ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		int patente = 0;	// Esto hay que modificarlo, hay que ver con que patente inicia el estacionamiento.
		a.iniciarEstacionamientoSEM(patente);
		
		// hacer el print que es la "notificacion" de inicio de estacionamiento.
	}
	
	public void notificarPosibleFinDeEstacionamiento(AplicacionUsuario a) {
		
		a.finalizarEstacionamientoSEM();
		// hacer el print que es la "notificacion" de inicio de estacionamiento.
	}
	
	public void activarODesactivarNotificaciones(AplicacionUsuario a) {
		// este mensaje no debe hacer nada.
	}
}
