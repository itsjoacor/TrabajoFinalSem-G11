import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsAplicacionUsuario {
	
	private AplicacionUsuario usu;
	private SistemaDeEstacionamientoMedido sem;
	private EstacionamientoMedianteApp est;
	private ModoDeUsoManual modoManualMockito = mock(ModoDeUsoManual.class);
	private EstadoEstacionamientoVigente estVigenteMockito = mock(EstadoEstacionamientoVigente.class);
	
	@BeforeEach
	public void setUp() {
		sem  = new SistemaDeEstacionamientoMedido();
		usu  = new AplicacionUsuario(sem, 1170142623);
	}

	@Test
	void testUnUsuarioIniciaUnEstacionamiento() {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		usu.iniciarEstacionamiento("jwm811");
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	
	@Test 
	void testUnUsuarioFinalizaUnEstacionamiento() {
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
		usu.establecerElModoDeUso(modoManualMockito);
		
		assertEquals(usu.getModoDeUso(), modoManualMockito);
	}
	
	@Test
	void testSaberSiEstanLasNotificacionesActivadas() {
		assertEquals(usu.notificacionesActivas(), true);
	}
	
	@Test
	void testPosibleInicioDeEstacionamientoPorModoAutomatico() {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		
		usu.notificarPosibleInicioEstacionamiento();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	
	@Test
	void testPosibleFinDeEstacionamientoPorModoAutomatico() {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		usu.iniciarEstacionamientoSEM("jwm811"); //Es lo mismo el mensaje que usamos para iniciar estacionamiento
		
		usu.notificarPosibleFinEstacionamiento();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, false);
	}
	
	@Test
	void testPosibleInicioDeEstacionamientoPorModoManual() {
		usu.establecerElModoDeUso(modoManualMockito);
		
		usu.notificarPosibleInicioEstacionamiento();
		
		verify(modoManualMockito).println("Alerta: Debe iniciar el estacionamiento.");
	}
	
	@Test
	void testPosibleFinDeEstacionamientoPorModoManual() {
		usu.establecerElModoDeUso(modoManualMockito);
		
		usu.notificarPosibleFinEstacionamiento(); //No hace falta iniciarlo en este test porque solo queremos recibir una notificacion
		
		verify(modoManualMockito).println("Alerta: Debe finalizar el estacionamiento que se encuentra vigente.");
	}
	
	@Test
	void testMiModoActivaODesactivaMisNotificaciones() {
		usu.establecerElModoDeUso(modoManualMockito);
		usu.activarODesactivarNotificaciones();
		
		assertEquals(usu.notificacionesActivas(), false); //Porque inician activadas.
	}
	
	@Test
	void testASeActivanODesactivanMisNotificaciones() {
		usu.activarODesactivarNotificaciones();
		
		assertEquals(usu.notificacionesActivas(), false);
	}
	
	@Test
	void testGetNumeroUsuario() {
		assertEquals(usu.getNumero(), 1170142623);
	}
	
	@Test
	void testGetPatenteUsuario() {
		usu.registrarPatente("jwm811");
		
		assertEquals(usu.getPatente(), "jwm811");
	}
	
	@Test
	void testQuieroIniciarEstacionamientoEnSEMPeroNoTengoPatenteRegistrada() {
		usu.iniciarEstacionamientoSEM("jwm811");
		
		verify(usu).println("Se debe registrar una patente antes de que se inicie el estacionamiento de forma automatica.");
	}
	
	@Test
	void testQuieroIniciarEstacionamientoEnSEMPeroNoTengoCreditoDisponible() {
		usu.registrarPatente("jwm811");
		usu.iniciarEstacionamientoSEM("jwm811");
		
		verify(usu).println("Saldo insuficiente. Estacionamiento no iniciado.");
	}
	
	@Test
	void testIniciarEstacionamientoEnSEM() {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		usu.iniciarEstacionamientoSEM("jwm811");
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	
	@Test
	void testFinalizarEstacionamientoEnSEM() {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		usu.iniciarEstacionamientoSEM("jwm811");
		
		usu.finalizarEstacionamientoSEM();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	
	@Test
	void testRegistrarPatente() {
		usu.registrarPatente("jwm811");
		
		assertEquals(usu.getPatente(), "jwm811");
	}
	
	@Test
	void testSetEstadoEstacionamiento () {
		usu.setEstado(estVigenteMockito);
		
		assertEquals(usu.getEstadoEstacionamiento(), estVigenteMockito);
	}
	
	@Test
	void testCambioSensorAppADriving() {
		usu.establecerElModoDeUso(modoManualMockito);
		usu.setEstado(estVigenteMockito);
		usu.driving();
		
		verify(usu).println("Alerta: Debe finalizar el estacionamiento que se encuentra vigente.");
	}
	
	@Test
	void testCambioSensorAppAWalking() {
		usu.establecerElModoDeUso(modoManualMockito);
		usu.walking(); //La app se encuentra al inicio en estado NO vigente
		
		verify(usu).println("Alerta: Debe iniciar el estacionamiento.");
	}

}
