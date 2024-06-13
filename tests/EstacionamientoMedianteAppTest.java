import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockedStatic;

public class EstacionamientoMedianteAppTest {

	private EstacionamientoMedianteApp estacionamiento;
	private LocalTime horaFin = LocalTime.of(18, 00);
	private String patente = "AA289LK";
	private int nroTelefono = 1121643962;
	private LocalTime horaInicio = LocalTime.now();
	
	
	@Test
	public void testConstructor() {
		estacionamiento = new EstacionamientoMedianteApp(patente, horaInicio, horaFin, nroTelefono);
		
		assertEquals(patente, estacionamiento.getPatente());
		assertEquals(horaInicio, estacionamiento.getHoraInicio());
		assertEquals(horaFin, estacionamiento.getHoraFin());
		assertEquals(nroTelefono, estacionamiento.getNumeroDeCelular());
	}
	
	@Test
	public void consultarVigenciaDeUnEstacionamientoMedianteApp() {

		LocalTime horaInicioSimulada = LocalTime.of(10, 00);
		LocalTime horaFin = LocalTime.of(18, 00);

		EstacionamientoMedianteApp estacionamiento = new EstacionamientoMedianteApp(patente, horaInicioSimulada, horaFin, nroTelefono);

		assertTrue(estacionamiento.estaVigente());
	}
	
	@Test
	public void seLeSeteaUnaHoraDeFinalizacionAUnEstacionamientoMedianteApp() {

		LocalTime nuevaHoraFin = LocalTime.of(19, 40);

		EstacionamientoMedianteApp estacionamiento = new EstacionamientoMedianteApp(patente, horaInicio, horaFin, nroTelefono);
		
		estacionamiento.setHoraFin(nuevaHoraFin);
		
		assertEquals(estacionamiento.getHoraFin(), nuevaHoraFin);
	}
	
}

