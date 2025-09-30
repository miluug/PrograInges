package org.example;

public class Veterinaria {

    // Atributos
    private String nit;
    private String nombre;

    // Atributos relacionales
    private Propietario[] listPropietarios;
    private Mascota[] listMascotas;


    public Veterinaria(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        this.listPropietarios = new Propietario[10];
        this.listMascotas = new Mascota[10];

    }

    // CRUD PROPIETARIO
    public boolean agregarPropietario(String numIdentificacion, String nombreCompleto, String numContacto, String direccion, int edad) {
        Propietario nuevoPropietario =
                new Propietario(numIdentificacion, nombreCompleto, numContacto, direccion, edad);

        for (int i = 0; i < listPropietarios.length; i++) {
            if (listPropietarios[i] != null && listPropietarios[i].getNumIdentificacion().equals(numIdentificacion)) {
                return false;
            }
        }
        for (int i = 0; i < listPropietarios.length; i++) {
            if(listPropietarios[i] == null){
                listPropietarios[i] = nuevoPropietario;
                return true;
            }
        }
        return false;
    }
    public boolean eliminarPropietario(String numIdentificacion){
        int indexPropietario = obtenerPosicionPropietario(numIdentificacion);

        if(indexPropietario == -1) return false;

        listPropietarios[indexPropietario] = null;
        return true;
    }

    public boolean actualizarPropietario(String numIdentificacion, String nombreCompleto, String numContacto, String direccion){

        int indexPropietario = obtenerPosicionPropietario(numIdentificacion);
        if(indexPropietario == -1) return false;

        Propietario propietarioActualizado = listPropietarios[indexPropietario];

        propietarioActualizado.setNombreCompleto(nombreCompleto);
        propietarioActualizado.setNumContacto(numContacto);
        propietarioActualizado.setDireccion(direccion);
        return true;
    }

    // CRUD MASCOTA
    public boolean agregarMascota(String codigo, String nombre, String tipo, String raza, int edad, String numIdentificacion) {
        Mascota nuevaMascota = new Mascota(codigo, nombre, tipo, raza, edad);
        Propietario propietario = obtenerPropietario(numIdentificacion);

        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] != null && listMascotas[i].getCodigo().equals(codigo)) {
                return false;
            }
        }
        for (int i = 0; i < listMascotas.length; i++) {
            if(listMascotas[i] == null){
                listMascotas[i] = nuevaMascota;
                propietario.agregarMascota(nuevaMascota);
                return true;
            }
        }
        return false;
    }
    public boolean eliminarMascota(String codigo, String numIdentificacion){

        int indexMascota = obtenerPosicionMascota(codigo);
        Propietario propietario = obtenerPropietario(numIdentificacion);
        if(indexMascota == -1) return false;

        listMascotas[indexMascota] = null;
        propietario.eliminarMascota(codigo);
        return true;
    }

    public boolean actualizarMascota(String codigo, String nombre, String tipo, String raza, int edad, String numIdentificacion){

        int indexMascota = obtenerPosicionMascota(codigo);
        Propietario propietario = obtenerPropietario(numIdentificacion);
        if(indexMascota == -1) return false;

        Mascota mascotaActualizada = listMascotas[indexMascota];

        mascotaActualizada.setNombre(nombre);
        mascotaActualizada.setTipo(tipo);
        mascotaActualizada.setRaza(raza);
        mascotaActualizada.setEdad(edad);
        propietario.editarMascota(codigo, nombre, tipo, raza, edad);
        return true;
    }


    //Métodos auxiliares

    private int obtenerPosicionPropietario(String numIdentificacion){
        for(int i = 0; i < listPropietarios.length; i++){
            if(listPropietarios[i] != null &&
                    listPropietarios[i].getNumIdentificacion().equals(numIdentificacion)){
                return i;
            }
        }
        return -1;
    }

    private int obtenerPosicionMascota(String codigo){
        for(int i = 0; i < listMascotas.length; i++){
            if(listMascotas[i] != null &&
                    listMascotas[i].getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }

    public Propietario obtenerPropietario(String numIdentificacion){
        for(int i = 0; i < listPropietarios.length; i++){
            if(listPropietarios[i] != null &&
                    listPropietarios[i].getNumIdentificacion().equals(numIdentificacion)){
                return listPropietarios[i];
            }
        }
        return null;
    }

    private Mascota obtenerMascota(String codigo){
        for(int i = 0; i < listMascotas.length; i++){
            if(listMascotas[i] != null &&
                    listMascotas[i].getCodigo().equals(codigo)){
                return listMascotas[i];
            }
        }
        return null;
    }


    public Propietario[] obtenerListaPropietarios() {
        return listPropietarios;
    }

    public Mascota[] obtenerListaMascotas() {
        return listMascotas;
    }

    public double calcularValorConsulta(String codigo) {
        Mascota mascota = obtenerMascota(codigo);
        double costoBase = 30000;

        // incremento por especie
        if (mascota.getTipo().equalsIgnoreCase("perro")) {
            costoBase += 5000;
        } else if (mascota.getTipo().equalsIgnoreCase("gato")) {
            costoBase += 3000;
        } else {
            costoBase += 2000; // para otras especies
        }

        // incremento por edad
        if (mascota.getEdad() > 10) {
            costoBase += 7000; // mascotas muy viejas
        } else if (mascota.getEdad() < 1) {
            costoBase += 4000; // cachorros o muy jóvenes
        }
        return costoBase;
    }

    // getters y setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // To String
    public String toString() {
        return "Veterinaria{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
