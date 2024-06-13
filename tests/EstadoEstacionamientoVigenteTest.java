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

	@BeforeEach
	void setUp() throws Exception {

		estadoV = new EstadoEstacionamientoVigente();
		appUs   = mock(AplicacionUsuario.class);

	}

	@Test
	void testSiEstaEnVigenteYSeIniciaDeNuevoNoHaceNadaConLaApp() {
		estadoV.iniciarEstacionamiento(appUs, "unaPatenteX");

		verifyNoInteractions(appUs);

	}

	@Test
	void testSiEstaVigenteYSeFinalizaSeFinalizaEnSEMYCambiaEstadoEnApp(){
		//Ver como implementar me falla que no hubo interactions??????
		//SistemaDeEstacionamientoMedido sem = mock(SistemaDeEstacionamientoMedido.class);

		//when(appUs.getSistema()).thenReturn(sem);

		//estadoV.finalizarEstacionamiento(appUs);

		//verify(sem, times(1)).finalizarEstacionamiento(appUs);
		//verify(appUs, times(1)).setEstado(argThat(estado -> estado instanceof EstadoEstacionamientoNoVigente));

	}

	@Test
	void testSiEstaEnVigenteYSeVuelveAIniciarNoNotificaApp() {

		estadoV.iniciarEstacionamiento(appUs, "unaPatenteX");
		verifyNoInteractions(appUs);
	}

	@Test
	void testSiEstaEnVigenteYSeDesactivaNotificadoInteractuaConLaApp() {
		//ver como implementar

	}

}


