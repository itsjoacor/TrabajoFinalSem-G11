
public class AplicacionUsuario extends AplicacionSEM {
	/*atributos en si*/
	private int     numeroDeCelular;
	private Double  creditoDisponible;
	private String  patente;
	private boolean notificacionesActivas;
	
	/*conoce a*/
	private ModoDeUso             modalidad;
	private EstadoEstacionamiento estado;
	
	
	
	public AplicacionUsuario(){
		
	}
	
	public void iniciarEstacionamiento(String patente){
	}
	
	public void finalizarEstacionamiento(int celular){
	}
	
	public void cargarCredito(double m){
	}
	
	public void creditoDisponible(){
	}
	
	public void cobrarMonto(double m){
	}
	
	public void establecerElModoDeUso(ModoDeUso m){
	}
	
	public void activarODesactivarNotificaciones(){
	}
	
	public boolean notificacionesActivas(){
	}
	
	public void notificarPosibleInicioEstacionamiento(){
	}
	
	public void notificarPosibleFinEstacionamiento(){
	}

}

