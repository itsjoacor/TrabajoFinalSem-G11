
public class ModoDeUsoManual implements ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			System.out.println("Alerta: Debe iniciar el estacionamiento.");
		}
		
	}
	
	public void notificarPosibleFinDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			System.out.println("Alerta: Debe finalizar el estacionamiento que se encuentra vigente.");
		}
	}
	
	public void activarODesactivarNotificaciones(AplicacionUsuario a) {
		
		a.aODesactivarNotificaciones();
	}

}
