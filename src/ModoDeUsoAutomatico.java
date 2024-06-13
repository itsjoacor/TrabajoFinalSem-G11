
public class ModoDeUsoAutomatico implements ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		a.iniciarEstacionamientoSEM(null);
		
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
