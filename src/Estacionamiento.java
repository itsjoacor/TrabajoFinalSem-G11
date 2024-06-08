import java.time.LocalTime;

public abstract class Estacionamiento {

	protected String patente;
	protected LocalTime horaInicio;
	protected LocalTime horaFin;

	
	public Estacionamiento(String p, LocalTime hi, LocalTime hf) {	
		patente = p;
		horaInicio = hi;
		horaFin = hf; 
	}

	public String getPatente() {
		return patente;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}

	public boolean estaVigente() {	
		
		return horaFin.isAfter(LocalTime.now());
	}

	public void setHoraFin(LocalTime hora) {
		horaFin = hora;
	}
}
