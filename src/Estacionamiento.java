import java.time.LocalTime;

public class Estacionamiento {
	
	private String patente;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private boolean estaVigente;

	
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

	public double montoACobrar() {
		return (this.horaFin.getHour() - this.horaInicio.getHour()) * 40;
	}

	public void darDeBaja() {
		//Si el estacionamiento no esta vigente, no cambia nada
		this.estaVigente = false;
	}
}
