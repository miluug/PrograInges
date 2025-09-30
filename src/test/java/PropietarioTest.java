import org.example.Propietario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropietarioTest {

    //Tests

    @Test
    void esMayorDeEdad() {
        Propietario p = new Propietario("123456", "Sandro", "123456789", "Calle 123", 20);
        assertTrue(p.esMayorDeEdad());
    }



}
