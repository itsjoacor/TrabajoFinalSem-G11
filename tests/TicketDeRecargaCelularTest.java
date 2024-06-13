import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TicketDeRecargaCelularTest{

    private PuntoDeVenta  pv;
    private LocalDateTime fyh;
    private TicketDeRecargaDeCelular      ticket;
    private ZonaDeEstacionamiento ze;
    private SistemaDeEstacionamientoMedido sem;

    @BeforeEach
    public void setUp() {
       ze     = mock(ZonaDeEstacionamiento.class);
       sem    = mock(SistemaDeEstacionamientoMedido.class);
       pv     = new PuntoDeVenta(ze, sem);
       fyh    = LocalDateTime.now();
       ticket = new TicketDeRecargaDeCelular(pv, fyh, 1500.d, 1121865149);
       
    }

    @Test
    public void testGetFechayHoraDeEmision() {
        assertEquals(LocalDateTime.now().getHour(), ticket.getFechayHoraDeEmision().getHour());
    }

    @Test
    public void testGetMontoFinal() {
        assertEquals(1500.d, ticket.getMontoFinal());
    }
    
    
    @Test
    public void testGetPuntoDeEmision() {
    	assertEquals(pv, ticket.getPuntoDeEmision()); // check
    }
    
    @Test
    public void testNumeroARecargar() {
    	assertEquals(1121865149, ticket.getNumeroRecargado());
    }
    
}