import java.time.LocalTime;

public class Estacionamiento {
	
	protected String patente;
	protected LocalTime horaInicio;
	protected LocalTime horaFin;
	protected boolean estaVigente;

	
	public Estacionamiento(String p, LocalTime hi, LocalTime hf) {	
		patente = p;
		horaInicio = hi;
		horaFin = hf;
		estaVigente = true;
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
		return estaVigente;
	}


	public void darDeBaja() {
		//Si el estacionamiento no esta vigente, no cambia nada
		this.estaVigente = false;
	}

}
