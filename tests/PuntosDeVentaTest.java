import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntosDeVentaTest {
	
	private AplicacionInspector insp;
	private ZonaDeEstacionamiento zona;
	private PuntoDeVenta pdv;
	private SistemaDeEstacionamientoMedido sem;
	private AplicacionUsuario usu;
	
	@BeforeEach
	public void setUp() {
		zona = new ZonaDeEstacionamiento(insp);
		sem  = new SistemaDeEstacionamientoMedido();
		pdv  = new PuntoDeVenta(zona, sem);
		insp = new AplicacionInspector(sem, 1234, zona);
		usu  = new AplicacionUsuario(sem, 1170142623);
		
		sem.registrarUsuario(usu);
		sem.registrarNuevaZona(zona);
		zona.registrarPuntoDeVenta(pdv);
	}
	
	@Test
	void testObtenerZonaDelPuntoDeVenta() {
		assertEquals(pdv.getZonaDelPunto(), zona);
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
	void testRegistrarEstacionamientoPorCompraPuntualPorMuchasHoras() {
		pdv.registrarEstacionamiento("jwm811", 20);
		boolean patenteVigente = sem.estaVigenteLaPatente("jwm811");
		
		assertEquals(patenteVigente, false); //Porque me pase de las 20hs
	}
	

	@Test
	void testCargaCelular() {
		pdv.cargarCelular(1170142623, 100);
		double creditoObtenido = usu.creditoDisponible();
		
		assertEquals(creditoObtenido, 100);
	}

}
