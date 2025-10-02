import org.example.Mascota;
import org.example.Propietario;
import org.example.Veterinaria;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class VeterinariaTest {
    Veterinaria veterinaria = new Veterinaria("123", "Huellitas");

    //Tests
    private static final Logger LOG = Logger.getLogger(VeterinariaTest.class.getName());

    @Test
    void testValidoPorLongitud (){
        LOG.info("Inicio de prueba testValidoPorLongitud...");
        assertTrue(veterinaria.validarId("123456789"));
        LOG.info("Fin de prueba testValidoPorLongitud...");

    }

    @Test
    void testInvalidoPorLongitud (){
        LOG.info("Inicio de prueba testInvalidoPorLongitud...");
        assertFalse(veterinaria.validarId("1234567"));
        LOG.info("Fin de prueba testInvalidoPorLongitud...");

    }
    @Test
    void testIdInvalidoNullOVacio() {
        LOG.info("Inicio de prueba testInvalidoNullOVacio...");
        assertFalse(veterinaria.validarId(null));
        assertFalse(veterinaria.validarId(""));
        assertFalse(veterinaria.validarId("   "));
        LOG.info("Fin de prueba testInvalidoNullOVacio...");
    }

}
