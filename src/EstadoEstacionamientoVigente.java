
public class EstadoEstacionamientoVigente implements EstadoEstacionamiento {
	
	public void driving() {
		
	}
	
	public void walking() {
	
	}
	
	
	public void finalizarEstacion() {
		//actualizar el usuario
		//decirle al sem qeu se actualice 
						
						
	}

	@Override
	public void cambiarEstado(AplicacionUsuario aplicacionUsuario) {
		
		aplicacionUsuario.setEstado(new EstadoEstacionamientoNoVigente());
		
	}
	
}
