
public class EstadoEstacionamientoVigente extends EstadoEstacionamiento {
	
	public void driving(AplicacionUsuario aplicacionUsuario) {
		
		aplicacionUsuario.notificarPosibleFinEstacionamiento();
	}
	
	
	public void finalizarEstacionamiento(AplicacionUsuario aplicacionUsuario) {
		
		aplicacionUsuario.finalizarEstacionamientoSEM();
	}
}
