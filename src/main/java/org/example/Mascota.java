package org.example;

public class Mascota {
    private String codigo;
    private String nombre;
    private Especie especie;
    private String raza;
    private int edad;
    private double peso;
    private CategoriaEdad categoriaEdad;

    // Constructor
    public Mascota(String codigo, String nombre, Especie especie, String raza, int edad, double peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.categoriaEdad = calcularCategoriaEdad(edad);
    }

    // To String
    public String toString() {
        return "Mascota: " +
                "Codigo: " + codigo + "\n" +
                "Nombre: " + nombre + "\n"+
                "Especie: " + especie + "\n"+
                "Raza: " + raza + "\n" +
                "Edad: " + edad + "\n"
                +"--------------------------------------------------\n";
    }

    // Calcular categoría edad
    private CategoriaEdad calcularCategoriaEdad(int edad) {
        if (edad <=12) {
            return CategoriaEdad.CACHORRO;
        } else {
            return CategoriaEdad.ADULTO;
        }
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

    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {

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
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public CategoriaEdad getCategoriaEdad() {
        return categoriaEdad;
    }
    public void setCategoriaEdad(CategoriaEdad categoriaEdad) {
        this.categoriaEdad = categoriaEdad;
    }
}

