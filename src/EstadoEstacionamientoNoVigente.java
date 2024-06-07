
public class EstadoEstacionamientoNoVigente extends EstadoEstacionamiento {
	
	
	public void walking(AplicacionUsuario aplicacionUsuario) {
		
		aplicacionUsuario.notificarPosibleInicioEstacionamiento();
	}
	
	public void iniciarEstacionamiento(AplicacionUsuario aplicacionUsuario, String patente) {
		
		aplicacionUsuario.iniciarEstacionamientoSEM(patente);
	}
}
