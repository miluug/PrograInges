package org.example;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria("123", "Veterinaria");
        int opcion = -1;

        do {
            String menu =
                    """
                             \
                            1. Agregar propietario
                            2. Agregar mascota
                            3. Editar propietario
                            4. Editar mascota
                            5. Eliminar propietario
                            6. Eliminar mascota
                            7. Listar propietarios
                            8. Listar mascotas
                            9. Calcular valor de consulta
                            10. Listar mascotas por propietario
                            0. Salir
                            """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    String id = JOptionPane.showInputDialog("ID del propietario:");
                    String nombre = JOptionPane.showInputDialog("Nombre del propietario:");
                    String contacto = JOptionPane.showInputDialog("Contacto del propietario:");
                    String direccion = JOptionPane.showInputDialog("Dirección del propietario:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del propietario:"));
                    boolean agregado = veterinaria.agregarPropietario(id, nombre, contacto, direccion, edad);
                    if (agregado) {
                        JOptionPane.showMessageDialog(null, "Propietario agregado");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
                    break;

                case 2:
                    String codigo = JOptionPane.showInputDialog("Código de la mascota:");
                    String nombreMascota = JOptionPane.showInputDialog("Nombre de la mascota:");
                    String tipo = JOptionPane.showInputDialog("Especie de la mascota:");
                    String raza = JOptionPane.showInputDialog("Raza de la mascota:");
                    int edadMas = Integer.parseInt(JOptionPane.showInputDialog("Edad de la mascota:"));
                    String idPropietario = JOptionPane.showInputDialog("ID del propietario:");

                    boolean agregadoM = veterinaria.agregarMascota(codigo, nombreMascota, tipo, raza, edadMas, idPropietario);
                    if (agregadoM) {
                        JOptionPane.showMessageDialog(null, "Mascota agregada");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar");
                    }
                    break;

                case 3:
                    String idP = JOptionPane.showInputDialog("ID del propietario:");
                    String nombreP = JOptionPane.showInputDialog("Nuevo nombre del propietario:");
                    String numeroP = JOptionPane.showInputDialog("Nuevo numero de contacto:");
                    String direccionP = JOptionPane.showInputDialog("Nueva direccion:");
                    boolean editadoP = veterinaria.actualizarPropietario(idP, nombreP, numeroP, direccionP);
                    if (editadoP) {
                        JOptionPane.showMessageDialog(null, "Propietario editado");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo editar");
                    }
                    break;

                case 4:
                    String codM = JOptionPane.showInputDialog("Código de la mascota:");
                    String nombreM = JOptionPane.showInputDialog("Nuevo nombre de la mascota:");
                    String tipoM = JOptionPane.showInputDialog("Nuevo tipo de la mascota:");
                    String razaM = JOptionPane.showInputDialog("Nueva raza de la mascota:");
                    int edadM = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad de la mascota:"));
                    String idPropietarioM = JOptionPane.showInputDialog("ID del propietario:");
                    boolean editadoM = veterinaria.actualizarMascota(codM, nombreM, tipoM, razaM, edadM, idPropietarioM);
                    if (editadoM) {
                        JOptionPane.showMessageDialog(null, "Mascota editada");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo editar");
                    }
                    break;

                case 5:
                    String idProp = JOptionPane.showInputDialog("ID del propietario a eliminar:");
                    boolean eliminadoP = veterinaria.eliminarPropietario(idProp);
                    if (eliminadoP) {
                        JOptionPane.showMessageDialog(null, "Propietario eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                    }
                    break;

                case 6:
                    String elimM = JOptionPane.showInputDialog("Código de la mascota a eliminar:");
                    String idPropietarioMascota = JOptionPane.showInputDialog("ID del propietario de la mascota:");
                    boolean eliminadoM = veterinaria.eliminarMascota(elimM, idPropietarioMascota);
                    if (eliminadoM) {
                        JOptionPane.showMessageDialog(null, "Mascota eliminada");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                    }
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, veterinaria.obtenerListaPropietarios());
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null, veterinaria.obtenerListaMascotas());
                    break;

                case 9:
                    String codigoMascota = JOptionPane.showInputDialog("Código de la mascota:");
                    JOptionPane.showMessageDialog(null, veterinaria.calcularValorConsulta(codigoMascota));
                    break;

                case 10:
                    String idPropietarioMas = JOptionPane.showInputDialog("ID del propietario:");
                    JOptionPane.showMessageDialog(null, veterinaria.obtenerPropietario(idPropietarioMas).obtenerListaMascotas());
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }
}

