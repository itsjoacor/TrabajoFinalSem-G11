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

	@BeforeEach
	void setUp(){
		appUs   = new AplicacionUsuario(sem, 1112345678);
		sem     = new SistemaDeEstacionamientoMedido();
		estadoV = new EstadoEstacionamientoVigente();
		
		sem.registrarUsuario(appUs);

	}

	@Test
	void testSiEstaEnVigenteYSeIniciaDeNuevoNoHaceNadaConLaApp() {
		estadoV.iniciarEstacionamiento(appUs, "unaPatenteX");
		
		verifyNoInteractions(appUs);

	}

	@Test
	void testSiEstaVigenteYSeFinalizaSeFinalizaEnSEMYCambiaEstadoEnApp(){
		
		when(appUs.getSistema()).thenReturn(sem);
		
		estadoV.finalizarEstacionamiento(appUs); 
		verify(sem, times(1)).finalizarEstacionamiento(Mockito.any());
		verify(appUs, times(1)).setEstado(argThat(estado -> estado instanceof EstadoEstacionamientoNoVigente));
	}

	
	
}


