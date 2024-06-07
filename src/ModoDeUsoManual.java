
public class ModoDeUsoManual extends ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			// hacer el print que es la "notificacion" de inicio de estacionamiento.
		}
		
	}
	
	public void notificarPosibleFinDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			// hacer el print que es la "notificacion" de fin de estacionamiento.
		}
	}
	
	public void activarODesactivarNotificaciones(AplicacionUsuario a) {
		
		a.activarODesactivarNotificaciones();
	}

}
