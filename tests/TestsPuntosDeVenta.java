import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsPuntosDeVenta {
	
	private AplicacionInspector insp;
	private ZonaDeEstacionamiento zona;
	private PuntoDeVenta pdv;
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario usu;
	
	@BeforeEach
	public void setUp() {
		sem  = new SistemaDeEstacionamientoMedido();
		pdv  = new PuntoDeVenta(zona, sem);
		insp = new AplicacionInspector(sem, 1234, zona);
		zona = new ZonaDeEstacionamiento(insp);
		usu  = new AplicacionUsuario(sem, 1170142623);
		
		sem.registrarUsuario(usu);
		sem.registrarNuevaZona(zona);
		zona.registrarPuntoDeVenta(pdv);
	}
	
	@Test
	void testObtenerZonaDelPuntoDeVenta() {
		ZonaDeEstacionamiento zonaPDV = pdv.getZonaDelPunto();
		
		assertEquals(zonaPDV, zona);
	}
	
	@Test
	void testObtenerSistemaDelPuntoDeVenta() {
		SistemaDeEstacionamientoMedido semPDV = pdv.getSistema();
	
		assertEquals(semPDV, sem);
	}
	
	@Test
	void testRegistrarEstacionamientoPorCompraPuntual() {
		pdv.registrarEstacionamiento("jwm811", 2);
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, true);
	}
	

	@Test
	void testCargaCelular() {
		pdv.cargarCelular(1170142623, 100);
		double creditoObtenido = usu.creditoDisponible();
		
		assertEquals(creditoObtenido, 100);
	}
	

}
