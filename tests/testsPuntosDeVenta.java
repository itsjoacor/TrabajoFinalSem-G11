import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testsPuntosDeVenta {
	
	private AplicacionInspector insp;
	private ZonaDeEstacionamiento zona;
	private PuntoDeVenta pdv;
	private Estacionamiento est;
	private SistemaDeEstacionamientoMedido sem;
	
	@BeforeEach
	public void setUp() {
		pdv = new PuntoDeVenta(zona, sem);
		Estacionamiento est = new Estacionamiento("jwm-811", LocalTime.now(), LocalTime.now().plusHours(2));
		sem = new SistemaDeEstacionamientoMedido();
		
		pdv.cargarCelular(1170142623, 100);
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
