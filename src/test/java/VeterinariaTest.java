import org.example.Mascota;
import org.example.Propietario;
import org.example.Veterinaria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VeterinariaTest {

    @Test
    void agregarMascota(){
        Veterinaria veterinaria = new Veterinaria("123", "Huellitas");
        boolean res = veterinaria.agregarPropietario("123", "Sandro", "123456789", "Calle 123", 20);
        assertTrue(veterinaria.agregarMascota("123", "Luna", "Perro", "Pitbull", 5, "123"));
    }
}
