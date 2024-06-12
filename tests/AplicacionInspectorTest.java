import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
	void testGetInspectorID(){
		assertEquals(1010, appIn.getInspectorId());
	}
	
	void testGetZona(){
		assertEquals(zona, appIn.getZonaDelInspector());
	}
	void testGetSem(){
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
		//terminar
		//falta ingresar El usuario al sistema y que tenga la patente dada para
		//poder verificar que este vigente
		AplicacionUsuario appUs = mock(AplicacionUsuario.class);

		
		when(sem.estaVigenteLaPatente("AA111BB")).thenReturn(false);
		appIn.consultarEstacionamiento("AA111BB");
		verify(sem).registrarNuevaInfraccion(any());
	
		
	}
	
	
	
	
	
}