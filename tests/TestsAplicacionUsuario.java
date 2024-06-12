import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsAplicacionUsuario {
	
	private AplicacionUsuario usu;
	private SistemaDeEstacionamientoMedido sem;
	private EstacionamientoMedianteApp est;
	private ModoDeUsoManual mm;
	
	@BeforeEach
	public void setUp() {
		sem  = new SistemaDeEstacionamientoMedido();
		usu  = new AplicacionUsuario(sem, 1170142623);
	}

	@Test
	void unUsuarioIniciaUnEstacionamiento() {
		usu.iniciarEstacionamiento("jwm811");
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	
	@Test 
	void unUsuarioFinalizaUnEstacionamiento() {
		usu.iniciarEstacionamiento("jwm811");
		usu.finalizarEstacionamiento();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, false);
	}
	
	@Test
	void testCargarCreditoAplicacion() {
		usu.cargarCredito(100);
		
		assertEquals(usu.creditoDisponible(), 100);
	}
	
	@Test
	void testObtenerCreditoDisponible() {
		assertEquals(usu.creditoDisponible(), 0);
	}
	
	@Test
	void testCobrarMonto() {
		usu.cargarCredito(100);
		usu.cobrarMonto(20);
		
		assertEquals(usu.creditoDisponible(), 70);
	}
	
	@Test
	void testEstablecerModoDeUso() {
		usu.establecerElModoDeUso(mm);
		
		assertEquals(usu.getModoDeUso(), mm);
	}
	
	@Test
	void testSaberSiEstanLasNotificacionesActivadas() {
		assertEquals(usu.notificacionesActivas(), true);
	}
	
	@Test
	void testPosibleInicioDeEstacionamientoPorModoAutomatico() {
		usu.notificarPosibleInicioEstacionamiento();
		
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		assertEquals(patenteVigente, true);
	}
	
	@Test
	void testPosibleInicioDeEstacionamientoPorModoManual() {
		usu.establecerElModoDeUso(mm);
		usu.notificarPosibleInicioEstacionamiento(); //Que hago aca si espero un print y no un resultado?? 
	}
	

}
