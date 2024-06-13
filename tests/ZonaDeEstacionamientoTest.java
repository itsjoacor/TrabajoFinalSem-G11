import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ZonaDeEstacionamientoTest {
	
	private ZonaDeEstacionamiento  zona;
	private PuntoDeVenta           pdv1;
	private PuntoDeVenta           pdv2;
	private AplicacionInspector   appIn; 
	
	@BeforeEach
	public void setUp() {
		appIn = mock(AplicacionInspector.class);
		zona  = new ZonaDeEstacionamiento(appIn);
		pdv1    = mock(PuntoDeVenta.class);
		pdv2    = mock(PuntoDeVenta.class);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(appIn, zona.getInspector());
		assertTrue(zona.getPuntosDeVentaDeLaZona().isEmpty());
		
	}
	@Test
	public void testInicialmenteEstaVacia() {
		assertTrue(zona.getPuntosDeVentaDeLaZona().isEmpty());
	}
	
	@Test
	public void testZonaAgregaPuntoDeVenta() {
		zona.registrarPuntoDeVenta(pdv1);
		zona.registrarPuntoDeVenta(pdv2);
		assertTrue(zona.getPuntosDeVentaDeLaZona().contains(pdv2));
		assertTrue(zona.getPuntosDeVentaDeLaZona().contains(pdv1));
	}
	@Test
	public void testGeterPuntosDeVentas(){
		zona.registrarPuntoDeVenta(pdv1);
		assertEquals(pdv1, zona.getPuntosDeVentaDeLaZona().get(0));
		assertTrue(zona.getPuntosDeVentaDeLaZona().contains(pdv1));
	}
	

	
}
