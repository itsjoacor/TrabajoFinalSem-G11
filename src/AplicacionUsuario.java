
public class AplicacionUsuario extends AplicacionSEM {
	/*atributos en si*/
	private int     numeroDeCelular;
	private Double  creditoDisponible;
	private String  patente;
	private boolean notificacionesActivas;
	
	/*conoce a*/
	private ModoDeUso                      modalidad;
	private EstadoEstacionamiento          estado;
	
	public AplicacionUsuario(int num, String p) {
		super();
		numeroDeCelular        = num;
		creditoDisponible      = 0.d;  /*asumo que se instancia en cero?*/
		patente                = p;
		notificacionesActivas  = true; /*por default vienen activadas? */
		estado                 = new EstadoEstacionamientoNoVigente();
		
	}
	
	public void iniciarEstacionamiento(){
		estado.iniciarEstacionamiento(this);
		
		/*ver que genera iniciar estacionamiento
		 * agregarlo al SEM
		 * generar un ticket
		 * genera  un estacionamiento
		 * etc*/
		
	}
	
	public void finalizarEstacionamiento(){
		estado.finalizarEstacionamiento(this);
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

	public void cambiarDeEstado() {
		this.estado.cambiarEstado(this);
	}
	
	public void setEstado(EstadoEstacionamiento e) {
		this.estado = e;
	}

}

