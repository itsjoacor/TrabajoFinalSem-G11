
public class AplicacionUsuario extends AplicacionSEM {
	/*atributos en si*/
	private int     numeroDeCelular;
	private Double  creditoDisponible;
	private String  patente;
	private boolean notificacionesActivas;
	
	/*conoce a*/
	private ModoDeUso                      modalidad;
	private EstadoEstacionamiento          estado;
	private SistemaDeEstacionamientoMedido sistema;
	
	
	public AplicacionUsuario(int num, String p, boolean notifAct) {
		numeroDeCelular        = num;
		creditoDisponible      = 0.d;  /*asumo que se instancia en cero?*/
		patente                = p;
		notificacionesActivas  = true; /*por default vienen activadas? */
		
	}
	
	public void iniciarEstacionamiento(String patente){
		/*ver que genera iniciar estacionamiento
		 * agregarlo al SEM
		 * generar un ticket
		 * genera  un estacionamiento
		 * etc*/
		
	}
	
	public void finalizarEstacionamiento(int celular){
		sistema.finalizarEstacionamiento(celular);
	}
	
	public void cargarCredito(double m){
		creditoDisponible += m;
	}
	
	public double creditoDisponible(){
		return creditoDisponible;
	}
	
	public void cobrarMonto(double m){
		creditoDisponible -= m;
	}
	
	public void establecerElModoDeUso(ModoDeUso m){
		modalidad = /*ver como se va a implementar*/
	}
	
	public void activarODesactivarNotificaciones(){
		notificacionesActivas = !notificacionesActivas;
		/*fijarse si es esto lo que se quiere*/
	}
	
	public boolean notificacionesActivas(){
		return notificacionesActivas;
	}
	
	public void notificarPosibleInicioEstacionamiento(){
	}
	
	public void notificarPosibleFinEstacionamiento(){
	}

	public int getNumero() {
		
		return numeroDeCelular;	
	}
	
	public String getPatente() {
		
		return patente;	
	}

}

