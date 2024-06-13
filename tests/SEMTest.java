import static org.junit.jupiter.api.Assertions.*;
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

class SEMTest {
	
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario usu;
	private EstacionamientoPorCompraPuntual estCP;
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SistemaDeEstacionamientoMedido();
		usu = new AplicacionUsuario(sem, 1170142223);
		usu.registrarPatente("jwm811");
		usu.cargarCredito(5000);
		sem.registrarUsuario(usu);
		
		estCP = new EstacionamientoPorCompraPuntual("jwm811", LocalTime.now(), LocalTime.now().plusHours(2), 80);
	}
	
	@Test
	void testCargarCelularAUsuario() {
		sem.cargarCelular(1170142223, 100);
		
		assertEquals(usu.creditoDisponible(), 5100);
	}
	
	@Test
	void testRegistrarTicket() {
		Ticket ticketMockito = mock(Ticket.class);
		sem.registrarTicket(ticketMockito);
		
		assertEquals(sem.getTickets().size(), 1);
	}
	
	@Test
	void testIniciarEstacionamientoEnElSEMMedianteApp() {
		EstacionamientoMedianteApp estMockito = mock(EstacionamientoMedianteApp.class);
		sem.iniciarEstacionamiento(estMockito, usu);
		
		assertEquals(sem.getEstacionamientos().size(), 1);
	}
	
	@Test
	void testIniciarEstacionamientoEnElSEMPorCompraPuntual() {
		sem.iniciarEstacionamiento(estCP);
		
		assertEquals(sem.getEstacionamientos().size(), 1);
	}
	
	@Test
	void testRegistrarNuevoUsuario() {
		AplicacionUsuario usuNuevoMockito = mock(AplicacionUsuario.class);
		sem.registrarUsuario(usuNuevoMockito);
		
		assertEquals(sem.getUsuarios().size(), 2);
	}
	
	@Test
	void testRegistrarNuevaInfraccion() {
		Infraccion infraccionMockito = mock(Infraccion.class);
		sem.registrarNuevaInfraccion(infraccionMockito);
		
		assertEquals(sem.getinfracciones().size(), 1);
	}
	
	@Test
	void testSaberSiEstaVigenteUnaPatente() {
		sem.iniciarEstacionamiento(estCP);
		
		assertEquals(sem.estaVigenteLaPatente("jwm811"), true);
	}
	
	@Test
	void testFinalizarEstacionamientoCompraPuntual() {
		sem.iniciarEstacionamiento(estCP);
		sem.finalizarEstacionamiento(1170142223);
		
		assertEquals(sem.estaVigenteLaPatente("jwm811"), false);
	}
	
	@Test
	void testFinalizarEstacionamientoMedianteApp() {
		sem.iniciarEstacionamiento(estCP, usu);
		sem.finalizarEstacionamiento(1170142223);
		
		assertEquals(sem.estaVigenteLaPatente("jwm811"), false);
	}

	@Test
	void finalizarTodosLosEstacionamientos() {
		AplicacionUsuario usuNuevoMockito = mock(AplicacionUsuario.class);
		sem.registrarUsuario(usuNuevoMockito);
		sem.iniciarEstacionamiento(estCP, usuNuevoMockito);
		sem.finalizarTodosLosEstacionamientos();
		
		verify(usuNuevoMockito, times(1)).finalizarEstacionamiento();
	}
	
	@Test
	void testSubscribirNuevoNotificado() {
		Notificable notifMockito = mock(Notificable.class);
		sem.subscribirNotificado(notifMockito);
		
		assertEquals(sem.getNotificados().size(), 1);
	}
	
	@Test
	void testDesuscscribirNotificado() {
		Notificable notifMockito = mock(Notificable.class);
		sem.subscribirNotificado(notifMockito);
		sem.desuscscribirNotificado(notifMockito);
		
		assertEquals(sem.getNotificados().size(), 0);
	}
	
	@Test
	void testSaberMontoParaPagarHorario() {
		double monto = sem.montoParaElHorario(LocalTime.now(), LocalTime.now().plusHours(2));
		
		assertEquals(monto, 80);
	}
	
	@Test
	void testSaberFinFranjaHorarioa() {
		assertEquals(sem.getHoraFinFranjaHoraria(), LocalTime.of(20, 0));
	}
	
	@Test
	void testRegistrarNuevaZonaDeEstacionamiento() {
		ZonaDeEstacionamiento zonaMockito = mock(ZonaDeEstacionamiento.class);
		sem.registrarNuevaZona(zonaMockito);
		
		assertEquals(sem.getZonasRegistradas().size(), 1);
	}
	
}
