
public class ModoDeUsoAutomatico extends ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		String patente = "";	// Esto hay que modificarlo, hay que ver con que patente inicia el estacionamiento.
		a.iniciarEstacionamientoSEM(patente);
		
		System.out.println("Alerta: Se inicio el estacionamiento de forma automatica.");
	}
	
	public void notificarPosibleFinDeEstacionamiento(AplicacionUsuario a) {
		
		a.finalizarEstacionamientoSEM();
	
		System.out.println("Alerta: Se finalizo el estacionamiento de forma automatica.");
	}
	
	public void activarODesactivarNotificaciones(AplicacionUsuario a) {
		// Este mensaje no debe hacer nada.
	}
}
