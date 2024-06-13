
public class ModoDeUsoManual implements ModoDeUso {
	
	public void notificarPosibleInicioDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			println("Alerta: Debe iniciar el estacionamiento.");
		}
		
	}
	
	public void notificarPosibleFinDeEstacionamiento(AplicacionUsuario a) {
		
		if (a.notificacionesActivas()) {
			println("Alerta: Debe finalizar el estacionamiento que se encuentra vigente.");
		}
	}
	
	public void activarODesactivarNotificaciones(AplicacionUsuario a) {
		
		a.aODesactivarNotificaciones();
	}

	public void println(String string) { // Este metodo nos facilita mucho mas verificar los tests, 
		System.out.println(string); 	 // afirmando que se ejecuto el print con el parametro que nosotros buscamos
	}

}
