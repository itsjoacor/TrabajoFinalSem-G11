import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class EstacionamientoCompraPuntualTest {
	

	@Test
	void testConstructor(){
		
		String    patente    = "unaPatentex";
		int       cantH      = 6;
		LocalTime horaInicio = LocalTime.now();
		LocalTime horaFin    = LocalTime.now().plusHours(cantH);
		
		EstacionamientoPorCompraPuntual eCP1 = new EstacionamientoPorCompraPuntual(patente, horaInicio, horaFin, cantH);
		assertEquals(patente, eCP1.getPatente());
		assertEquals(horaInicio, eCP1.getHoraInicio());
		assertEquals(horaFin, eCP1.getHoraFin());
	}
	
	
	@Test
	public void testEstacionamientoSabeCuandoEstaONoVigente() {
		String    patente    = "unaPatentex";
		int       cantH      = 6;
		LocalTime horaInicio = LocalTime.now();
		LocalTime horaFin    = LocalTime.now().plusHours(cantH);
		
		EstacionamientoPorCompraPuntual eCP1 = new EstacionamientoPorCompraPuntual(patente, horaInicio, horaFin, cantH);
		
		

		assertTrue(eCP1.estaVigente());
	}
	
	
	


}
