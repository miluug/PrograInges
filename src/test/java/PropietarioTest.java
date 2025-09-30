import org.example.Propietario;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class PropietarioTest {

    //Tests
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());
    @Test
    void esMayorDeEdad() {
        LOG.info("Inicio de prueba esMayorDeEdad...");
        Propietario p = new Propietario("123456", "Sandro", "123456789", "Calle 123", 20);
        assertTrue(p.esMayorDeEdad());
        LOG.info("Fin de prueba esMayorDeEdad...");
    }

    @Test
    void esMenorDeEdad() {
        LOG.info("Inicio de prueba esMenorDeEdad...");
        Propietario p = new Propietario("123457", "Milita", "987654321", "Calle 456", 16);
        assertFalse(p.esMayorDeEdad());
        LOG.info("Fin de prueba esMenorDeEdad...");
    }
}
