package org.example;

public class Propietario {
    private String numIdentificacion;
    private String nombreCompleto;
    private String numContacto;
    private String direccion;
    private int edad;
    private Mascota[] listMascotas;

    public Propietario(String numIdentificacion, String nombrePropietario, String numContacto, String direccion, int edad) {
        this.numIdentificacion = numIdentificacion;
        this.nombreCompleto = nombrePropietario;
        this.numContacto = numContacto;
        this.direccion = direccion;
        this.edad = edad;
        this.listMascotas = new Mascota[3];
    }


    // Obtener lista de mascotas
    public Mascota[] obtenerListaMascotas() {
        return listMascotas;
    }

    // Getters y Setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    // To String
    public String toString() {
        return "Propietario: " +
                "ID: " + numIdentificacion + "\n" +
                "Nombre:" + nombreCompleto + "\n" +
                "Numero de Contacto: " + numContacto + "\n" +
                "Edad:" + edad + "\n" +
                "Direccion: " + direccion + "\n"+
                "--------------------------------------------------\n";
    }

    // CRUD MASCOTA

    public boolean agregarMascota(Mascota mascota) {
        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] == null) {
                listMascotas[i] = mascota;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarMascota(String codigo) {
        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] != null && listMascotas[i].getCodigo().equals(codigo)) {
                listMascotas[i]= null;
            }
        }
        return false;
    }

    public boolean editarMascota(String codigo, String nombre, String tipo, String raza, int edad) {
        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] != null && listMascotas[i].getCodigo().equals(codigo)) {
                listMascotas[i].setNombre(nombre);
                listMascotas[i].setTipo(tipo);
                listMascotas[i].setRaza(raza);
                listMascotas[i].setEdad(edad);
                return true;
            }
        }
        return false;
    }

    //Metodo nuevo

    public boolean esMayorDeEdad (){
        return this.edad>=18;
    }
}
