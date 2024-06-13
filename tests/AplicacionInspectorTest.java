import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AplicacionInspectorTest {
	private SistemaDeEstacionamientoMedido sem;
	private int                            inspID;
	private ZonaDeEstacionamiento          zona;
	private AplicacionInspector            appIn;

	
	
	@BeforeEach
	public void setUp() {
		sem    = mock(SistemaDeEstacionamientoMedido.class);
		zona   = mock(ZonaDeEstacionamiento.class);
		inspID = 1010;
		appIn = new AplicacionInspector(sem, inspID, zona);
		
		
		

	}
	// constructor
	@Test
	void testConstructorInspector(){
		
		assertEquals(1010, appIn.getInspectorId());
		assertEquals(appIn.getZonaDelInspector(), zona);
		assertEquals(sem, appIn.getSistema());
	}
	
		
	
	// usage
	@Test
	void unaPatenteQueNoEstaRegistradaObtieneInfraccion(){
		when(sem.estaVigenteLaPatente("unaPatente")).thenReturn(false);
		appIn.consultarEstacionamiento("unaPatente");
		verify(sem).registrarNuevaInfraccion(any());
		
	}
	
	@Test
	void unaPatenteQueSiEstaRegistradaNOObtieneInfraccion(){
		when(sem.estaVigenteLaPatente("unaPatentex")).thenReturn(true);
		appIn.consultarEstacionamiento("unaPatentex");
		
		verify(sem).estaVigenteLaPatente("unaPatentex");
	    verifyNoMoreInteractions(sem);
	
	}
	
}