import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModoDeUsoManualTest {
	
	private ModoDeUsoManual mmMockito;
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario usu;
	
	@BeforeEach
	void setUp() throws Exception {
		mmMockito = mock(ModoDeUsoManual.class);
		sem = new SistemaDeEstacionamientoMedido();
		usu = new AplicacionUsuario(sem, 1170142623);
		usu.establecerElModoDeUso(mmMockito);
	}

	@Test
	void testNotificarPosibleInicioDeEstacionamiento() {
		usu.walking();
		
		verify(mmMockito, times(1)).notificarPosibleInicioDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testNotificarPosibleFinDeEstacionamiento() {
		usu.setEstado(new EstadoEstacionamientoVigente());
		usu.driving();
		
		verify(mmMockito, times(1)).notificarPosibleFinDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testActivarODesactivarNotificacionesUsuario() {
		usu.activarODesactivarNotificaciones();
		
		verify(mmMockito, times(1)).activarODesactivarNotificaciones(Mockito.any());
	}

}
