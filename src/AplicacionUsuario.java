import java.time.LocalTime;

public class AplicacionUsuario extends AplicacionSEM implements MovementSensor  {
	
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
	
	public void iniciarEstacionamiento(String patente){
		estado.iniciarEstacionamiento(this, patente);
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
	
	public ModoDeUso getModoDeUso() {
		return modalidad;
	}
	
	public boolean notificacionesActivas(){
		return notificacionesActivas;
	}
	
	public void notificarPosibleInicioEstacionamiento(){
		this.modalidad.notificarPosibleInicioDeEstacionamiento(this);
	}
	
	public void notificarPosibleFinEstacionamiento(){
		this.modalidad.notificarPosibleFinDeEstacionamiento(this);
	}

	public void activarODesactivarNotificaciones(){
		this.modalidad.activarODesactivarNotificaciones(this);
	}
	
	public void aODesactivarNotificaciones() {
		notificacionesActivas = !notificacionesActivas;
	}
	
	public int getNumero() {
		
		return numeroDeCelular;	
	}
	
	public String getPatente() {
		
		return patente;	
	}
	
	public void iniciarEstacionamientoSEM(String patente) {
		
		if(patente != null) {
			this.patente = patente;
		}
		
		if (this.patente == null) {
			System.out.println("Se debe registrar una patente antes de que se inicie el estacionamiento de forma automatica.");
		} 
		else {
				if (hayCreditoDisponible()) {
					LocalTime horaDeFin = sistema.getHoraFinFranjaHoraria();
					EstacionamientoMedianteApp estacionamientoNuevo = new EstacionamientoMedianteApp(this.patente, LocalTime.now(), horaDeFin, numeroDeCelular);
					getSistema().iniciarEstacionamiento(estacionamientoNuevo, this);
					setEstado(new EstadoEstacionamientoVigente());
			}
				else {
					System.out.println("Saldo insuficiente. Estacionamiento no iniciado.");
			}
		}
	}

	public void finalizarEstacionamientoSEM() {
		
		getSistema().finalizarEstacionamiento(numeroDeCelular);
		setEstado(new EstadoEstacionamientoNoVigente());
	}

	private boolean hayCreditoDisponible() {
	        																											// Aclaracion: si el dia de mañana cambia la hora de fin, no se tiene que modificar la clase AplicacionUsuario.
		double creditoNecesario = sistema.montoParaElHorario(LocalTime.now(), sistema.getHoraFinFranjaHoraria());		// Aclaracion: si el dia de mañana cambia el precio por hora, no se tiene que modificar la clase AplicacionUsuario.
		return creditoDisponible >= creditoNecesario;
	}
	
	public void registrarPatente(String patente) {
		this.patente = patente;
	}
	
	
	public void setEstado(EstadoEstacionamiento e) {
		this.estado = e;
		this.notificacionesActivas = true;
	}
	
	public EstadoEstacionamiento getEstadoEstacionamiento() {
		return this.estado;
	}
	
	public void driving() {
		this.estado.driving(this);
	}
	
	public void walking() {
		this.estado.walking(this);
	}

}

