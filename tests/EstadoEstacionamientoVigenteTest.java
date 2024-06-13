import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EstadoEstacionamientoVigenteTest {
	private EstadoEstacionamiento estadoV;
	private AplicacionUsuario     appUs;
	private SistemaDeEstacionamientoMedido sem;
	private ModoDeUsoManual modoManualMockito;

	@BeforeEach
	void setUp(){
		sem     = new SistemaDeEstacionamientoMedido();
		appUs   = new AplicacionUsuario(sem, 1112345678);
		estadoV = new EstadoEstacionamientoVigente();
		modoManualMockito = mock(ModoDeUsoManual.class);
		
		sem.registrarUsuario(appUs);
		appUs.establecerElModoDeUso(modoManualMockito);
	}
	
	@Test
	void testUsuarioPasaAEstadoDriving() {
		appUs.setEstado(estadoV);
		appUs.driving();
		
		verify(modoManualMockito, times(1)).notificarPosibleFinDeEstacionamiento(Mockito.any());
	}
	
	@Test
	void testFinalizarEstacionamientoEnEstado() {
		appUs.registrarPatente("jwm811");
		appUs.cargarCredito(5000);
		appUs.iniciarEstacionamiento("jwm811");
		
		estadoV.finalizarEstacionamiento(appUs);
		assertFalse(sem.estaVigenteLaPatente("jwm811"));
		
	}
	
}


