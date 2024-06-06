
public class EstadoEstacionamientoNoVigente implements EstadoEstacionamiento {
	
	public void driving() {
		
	}
	
	public void walking() {
		
	}

	@Override
	public void cambiarEstado(AplicacionUsuario aplicacionUsuario) {
		
		aplicacionUsuario.setEstado(new EstadoEstacionamientoVigente());
		
	}

}
