import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SEMTest {
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario user;

	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SistemaDeEstacionamientoMedido();
	}
	
	

}
