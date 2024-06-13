import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModoDeUsoAutomaticoTest {

	private ModoDeUsoAutomatico maMockito;
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario usu;
	
	@BeforeEach
	void setUp() throws Exception {
		maMockito = mock(ModoDeUsoAutomatico.class);
		sem = new SistemaDeEstacionamientoMedido();
		usu = new AplicacionUsuario(sem, 1170142623);
		usu.establecerElModoDeUso(maMockito);
	}

	@Test
	void testNotificarPosibleInicioDeEstacionamiento() {
		usu.walking();
		
		verify(maMockito, times(1)).notificarPosibleInicioDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testNotificarPosibleFinDeEstacionamiento() {
		usu.setEstado(new EstadoEstacionamientoVigente());
		usu.driving();
		
		verify(maMockito, times(1)).notificarPosibleFinDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testActivarODesactivarNotificacionesUsuario() {
		usu.activarODesactivarNotificaciones();
		
		verify(maMockito, times(1)).activarODesactivarNotificaciones(Mockito.any());
	}

}
