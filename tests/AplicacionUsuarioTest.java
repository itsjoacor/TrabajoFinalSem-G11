import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AplicacionUsuarioTest {
	
	private AplicacionUsuario usu;
	private SistemaDeEstacionamientoMedido sem;
	private ModoDeUsoManual modoManualMockito = mock(ModoDeUsoManual.class);
	private ModoDeUsoManual modoManual = new ModoDeUsoManual();
	private EstadoEstacionamientoVigente estVigenteMockito = mock(EstadoEstacionamientoVigente.class);
	
	@BeforeEach
	public void setUp() {
		sem  = new SistemaDeEstacionamientoMedido();
		usu  = new AplicacionUsuario(sem, 1170142623);
		sem.registrarUsuario(usu);
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
		
		assertEquals(usu.creditoDisponible(), 80);
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
		usu.iniciarEstacionamiento("jwm811"); //Es lo mismo el mensaje que usamos para iniciar estacionamiento
		
		usu.notificarPosibleFinEstacionamiento();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, false);
	}
	
	@Test
	void testPosibleInicioDeEstacionamientoPorModoManual() {
		usu.establecerElModoDeUso(modoManualMockito);
		
		usu.notificarPosibleInicioEstacionamiento();

		verify(modoManualMockito, times(1)).notificarPosibleInicioDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testPosibleFinDeEstacionamientoPorModoManual() throws Exception {
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		usu.iniciarEstacionamientoSEM("jwm811");
		usu.establecerElModoDeUso(modoManualMockito);
		
		usu.notificarPosibleFinEstacionamiento(); //No hace falta iniciarlo en este test porque solo queremos recibir una notificacion
		
		
		verify(modoManualMockito, times(1)).notificarPosibleFinDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testMiModoActivaODesactivaMisNotificacionesConModoManual() {
		usu.establecerElModoDeUso(modoManual);
		usu.activarODesactivarNotificaciones();
		
		assertEquals(usu.notificacionesActivas(), false); //Porque inician activadas.
	}
	
	@Test
	void testASeActivanODesactivanMisNotificacionesModoManual() {
		usu.establecerElModoDeUso(new ModoDeUsoManual());
		usu.aODesactivarNotificaciones();
		
		assertEquals(usu.notificacionesActivas(), false);
	}
	
	@Test
	void testMiModoActivaODesactivaMisNotificacionesConModoAutomatico() {
		usu.activarODesactivarNotificaciones();
		
		assertEquals(usu.notificacionesActivas(), true); //Porque no cambia nada
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
	void testIniciarEstacionamientoEnSEM() throws Exception {
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
		usu.iniciarEstacionamiento("jwm811");
		
		usu.finalizarEstacionamientoSEM();
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, false);
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
		usu.setEstado(new EstadoEstacionamientoVigente());
		usu.driving();
		
		verify(modoManualMockito, times(1)).notificarPosibleFinDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testCambioSensorAppAWalking() {
		usu.establecerElModoDeUso(modoManualMockito);
		usu.walking(); //La app se encuentra al inicio en estado NO vigente
		
		verify(modoManualMockito, times(1)).notificarPosibleInicioDeEstacionamiento(Mockito.any());
	}

}
