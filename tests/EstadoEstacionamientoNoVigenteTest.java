import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EstadoEstacionamientoNoVigenteTest {

	private EstadoEstacionamiento estadoNV;
	private AplicacionUsuario              appUs;
	private SistemaDeEstacionamientoMedido sem;
	private ModoDeUsoManual modoManualMockito;

	@BeforeEach
	void setUp(){

		sem     = new SistemaDeEstacionamientoMedido();
		estadoNV = new EstadoEstacionamientoNoVigente();
		modoManualMockito = mock(ModoDeUsoManual.class);
		
	}

	
	@Test
	void testSiEstaEnEstadoNoVigenteFinalizarNoInteractuaConApp() {
		AplicacionUsuario appUs = mock(AplicacionUsuario.class);
		estadoNV.finalizarEstacionamiento(appUs);

		verifyNoInteractions(appUs);
	}

	@Test
	void testElUsuarioPasaAEstadoWalking() {
		appUs = new AplicacionUsuario(sem, 1112345678);
		sem.registrarUsuario(appUs);
		appUs.establecerElModoDeUso(modoManualMockito);
		appUs.setEstado(estadoNV);
		appUs.walking();
		
		verify(modoManualMockito, times(1)).notificarPosibleInicioDeEstacionamiento(Mockito.any());
	}
	

}
