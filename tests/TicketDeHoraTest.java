import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TicketDeHoraTest{

    private PuntoDeVenta  pv;
    private LocalDateTime fyh;
    private TicketDeHoras       ticket;
    private ZonaDeEstacionamiento ze;
    private SistemaDeEstacionamientoMedido sem;

    @BeforeEach
    public void setUp() {
       ze     = mock(ZonaDeEstacionamiento.class);
       sem    = mock(SistemaDeEstacionamientoMedido.class);
       pv     = new PuntoDeVenta(ze, sem);
       fyh    = LocalDateTime.now();
       ticket = new TicketDeHoras(pv, fyh, 1500.d, 6);
       
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
    public void testHorasCompradas() {
    	assertEquals(6, ticket.getCantidadDeHoraCompradas());
    }
    
    @Test
    public void testGetPuntoDeEmision() {
    	assertEquals(pv, ticket.getPuntoDeEmision()); // check
    }
    
    
}