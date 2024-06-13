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

	@BeforeEach
	void setUp(){

		estadoNV = new EstadoEstacionamientoNoVigente();
		appUs    = mock(AplicacionUsuario.class);
		sem      = mock(SistemaDeEstacionamientoMedido.class);
	}

	
	@Test
	void testSiEstaEnEstadoNoVigenteFinalizarNoInteractuaConApp() {
		estadoNV.finalizarEstacionamiento(appUs);

		verifyNoInteractions(appUs);
	}

	//Ver que otros tests hacer
	

}
