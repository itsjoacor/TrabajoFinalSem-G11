import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfraccionTest {
	private ZonaDeEstacionamiento zona;
	private String                patente;
	private LocalDate             fechaEmision;
	private LocalTime             horaEmision;	
	private int                   inspectorID;
	private Infraccion            infraccion;

	
	
	@BeforeEach
	public void setUp() {
		zona         = mock(ZonaDeEstacionamiento.class);
		patente      = "AA111BB";
		fechaEmision = LocalDate.now();
		horaEmision  = LocalTime.now();
		inspectorID  = 1010;	
		
		infraccion  = new Infraccion(patente, fechaEmision, horaEmision, inspectorID, zona);
	}
	
	@Test
	void testGetPatente() {
		assertEquals("AA111BB", infraccion.getPatente());
	}
	
	@Test
	void testGetFechaEmision() {
		assertEquals(LocalDate.now(), infraccion.getFechaEmision());
	}
	
	@Test
	void testGetHorarioEmision() {
		assertEquals(LocalTime.now().getHour(), infraccion.getHoraEmision().getHour());
	}
	
	@Test
	void testGerInspectorID() {
		assertEquals(1010, infraccion.getInspectorID());
	}
	
	@Test
	void testGetZona() {
		assertEquals(zona, infraccion.getZona());
	}

}
