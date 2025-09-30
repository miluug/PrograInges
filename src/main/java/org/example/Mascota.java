package org.example;

public class Mascota {
    private String codigo;
    private String nombre;
    private String tipo;
    private String raza;
    private int edad;

    // Constructor
    public Mascota(String codigo, String nombre, String tipo, String raza, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
    }

    // To String
    public String toString() {
        return "Mascota: " +
                "Codigo: " + codigo + "\n" +
                "Nombre: " + nombre + "\n"+
                "Tipo: " + tipo + "\n"+
                "Raza: " + raza + "\n" +
                "Edad: " + edad + "\n"
                +"--------------------------------------------------\n";
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

