import java.time.LocalTime;

public class AplicacionUsuario extends AplicacionSEM {
	
	private int     numeroDeCelular;
	private Double  creditoDisponible;
	private String  patente;
	private boolean notificacionesActivas;
	private ModoDeUso modalidad;
	private EstadoEstacionamiento estado;
	
	
	public AplicacionUsuario(SistemaDeEstacionamientoMedido s, int num) {
		super(s);
		numeroDeCelular        = num;
		creditoDisponible      = 0.d;
		notificacionesActivas  = true;
		estado                 = new EstadoEstacionamientoNoVigente();
		modalidad			   = new ModoDeUsoAutomatico();
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
		modalidad = m;
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
	
	public void iniciarEstacionamientoSEM(String patente){
		
		this.patente = patente;
		// hay que hacer un if para ver si tiene el credito suficiente. y si no lo tiene notificar que no se inicio pq no tiene saldo.
		LocalTime horaDeFin = LocalTime.of(20, 0);
		EstacionamientoMedianteApp estacionamientoNuevo = new EstacionamientoMedianteApp(patente, LocalTime.now(), horaDeFin, numeroDeCelular);
		getSistema().registarEstacionamiento(estacionamientoNuevo);
	}


	public void finalizarEstacionamientoSEM() {
		
		getSistema().finalizarEstacionamiento(numeroDeCelular);
	}

	public void cambiarDeEstado() {
		this.estado.cambiarEstado(this);
	}
	
	public void setEstado(EstadoEstacionamiento e) {
		this.estado = e;
	}


}

