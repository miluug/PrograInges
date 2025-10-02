package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veterinaria {

    // Atributos
    private String nit;
    private String nombre;

    // Atributos relacionales
    private ArrayList <Propietario> listPropietarios;
    private ArrayList <Mascota> listMascotas;
    private ArrayList <AtencionMedica> listAtenciones;


    public Veterinaria(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        this.listPropietarios = new ArrayList<>();
        this.listMascotas = new ArrayList<>();
        this.listAtenciones = new ArrayList<>();

    }
    /*
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
    public boolean agregarMascota(String codigo, String nombre, String especie, String raza, int edad, double peso, String numIdentificacion) {
        Mascota nuevaMascota = new Mascota(codigo, nombre, especie, raza, edad, peso);
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

    public boolean actualizarMascota(String codigo, String nombre, String especie, String raza, int edad,double peso, String numIdentificacion){

        int indexMascota = obtenerPosicionMascota(codigo);
        Propietario propietario = obtenerPropietario(numIdentificacion);
        if(indexMascota == -1) return false;

        Mascota mascotaActualizada = listMascotas[indexMascota];

        mascotaActualizada.setNombre(nombre);
        mascotaActualizada.setEspecie(especie);
        mascotaActualizada.setRaza(raza);
        mascotaActualizada.setEdad(edad);
        propietario.editarMascota(codigo, nombre, especie, raza, edad, peso);
        return true;
    }
    */

    // CRUDS actualizados

    // CRUD PROPIETARIO
    public boolean agregarPropietario(String numIdentificacion, String nombreCompleto, String numContacto, String direccion, int edad) {
        Propietario propietario = new Propietario(numIdentificacion, nombreCompleto, numContacto, direccion, edad);
        for (int i = 0; i < listPropietarios.size(); i++) {
            if (listPropietarios.get(i) != null && listPropietarios.get(i).getNumIdentificacion().equals(numIdentificacion)) {
                return false;
            }
        }
        listPropietarios.add(propietario);
        return true;
    }

    public boolean eliminarPropietario(String numIdentificacion){
        for (int i = 0; i < listPropietarios.size(); i++) {
            if (listPropietarios.get(i) != null && listPropietarios.get(i).getNumIdentificacion().equals(numIdentificacion)) {
                listPropietarios.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPropietario(String numIdentificacion, String nombreCompleto, String numContacto, String direccion){
        for (int i = 0; i < listPropietarios.size(); i++) {
            if (listPropietarios.get(i) != null && listPropietarios.get(i).getNumIdentificacion().equals(numIdentificacion)) {
                listPropietarios.get(i).setNombreCompleto(nombreCompleto);
                listPropietarios.get(i).setNumContacto(numContacto);
                listPropietarios.get(i).setDireccion(direccion);
                return true;
            }
        }
        return false;
    }

    // CRUD MASCOTA
    public boolean agregarMascota(String codigo, String nombre, Especie especie, String raza, int edad, double peso, String numIdentificacion) {
        Mascota mascota = new Mascota(codigo, nombre, especie, raza, edad, peso);
        Propietario propietario = obtenerPropietario(numIdentificacion);
        propietario.agregarMascota(mascota);
        listMascotas.add(mascota);
        return true;
    }

    public boolean eliminarMascota(String codigo, String numIdentificacion){
        for (int i = 0; i < listMascotas.size(); i++) {
            if (listMascotas.get(i) != null && listMascotas.get(i).getCodigo().equals(codigo)) {
                listMascotas.remove(i);
                Propietario propietario = obtenerPropietario(numIdentificacion);
                propietario.eliminarMascota(codigo);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarMascota(String codigo, String nombre, String especie, String raza, int edad, double peso, String numIdentificacion){
        for (int i = 0; i < listMascotas.size(); i++) {
            if (listMascotas.get(i) != null && listMascotas.get(i).getCodigo().equals(codigo)) {
                listMascotas.get(i).setNombre(nombre);
                listMascotas.get(i).setEspecie(especie);
                listMascotas.get(i).setRaza(raza);
                listMascotas.get(i).setEdad(edad);
                listMascotas.get(i).setPeso(peso);
                Propietario propietario = obtenerPropietario(numIdentificacion);
                propietario.editarMascota(codigo, nombre, especie, raza, edad, peso);
                return true;
            }
        }
        return false;
    }

    // CRUD ATENCION

    public boolean agregarAtencion (String numeroAtencion, LocalDate fecha, TipoConsulta tipoConsulta, double valorBase, String codigoMascota) {
        Mascota mascota = obtenerMascota(codigoMascota);
        AtencionMedica atencion = new AtencionMedica(numeroAtencion, fecha, mascota, tipoConsulta, valorBase);
        for (int i = 0; i < listAtenciones.size(); i++) {
            if (listAtenciones.get(i) != null && listAtenciones.get(i).getNumeroAtencion().equals(numeroAtencion)) {
                return false;
            }
        }
        listAtenciones.add(atencion);
        return true;
    }

    public boolean eliminarAtencion (String numeroAtencion){
        for (int i = 0; i < listAtenciones.size(); i++) {
            if (listAtenciones.get(i) != null && listAtenciones.get(i).getNumeroAtencion().equals(numeroAtencion)) {
                listAtenciones.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarAtencion (String numeroAtencion, LocalDate fecha, TipoConsulta tipoConsulta, double valorBase){
        for (int i = 0; i < listAtenciones.size(); i++) {
            if (listAtenciones.get(i) != null && listAtenciones.get(i).getNumeroAtencion().equals(numeroAtencion)) {
                listAtenciones.get(i).setFecha(fecha);
                listAtenciones.get(i).setTipoConsulta(tipoConsulta);
                listAtenciones.get(i).setValorBase(valorBase);
                return true;
            }
        }
        return false;
    }



    //Métodos aux antiguos

   /* private int obtenerPosicionPropietario(String numIdentificacion){
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

    public Mascota obtenerMascota(String codigo){
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
    */

    // Métodos aux nuevos

    public Propietario obtenerPropietario(String numIdentificacion) {
        for (int i = 0; i < listPropietarios.size(); i++) {
            if (listPropietarios.get(i) != null && listPropietarios.get(i).getNumIdentificacion().equals(numIdentificacion)) {
                return listPropietarios.get(i);
            }
        }
        return null;
    }

    public Mascota obtenerMascota(String codigo) {
        for (int i = 0; i < listMascotas.size(); i++) {
            if (listMascotas.get(i) != null && listMascotas.get(i).getCodigo().equals(codigo)) {
                return listMascotas.get(i);
            }
        }
        return null;
    }

    public AtencionMedica obtenerAtencion(String numeroAtencion) {
        for (int i = 0; i < listAtenciones.size(); i++) {
            if (listAtenciones.get(i) != null && listAtenciones.get(i).getNumeroAtencion().equals(numeroAtencion)) {
                return listAtenciones.get(i);
            }
        }
        return null;
    }


    public double calcularValorConsulta(String numeroAtencion) {
        AtencionMedica atencion = obtenerAtencion(numeroAtencion);
        Mascota mascota = atencion.getMascota();
        double valorBase = atencion.getValorBase();
        double costoFinal = valorBase;

        if (mascota.getEspecie() == Especie.REPTIL || mascota.getEspecie() == Especie.AVE) {
            costoFinal *= 1.1;
        }

        if (mascota.getCategoriaEdad() == CategoriaEdad.ADULTO) {
            costoFinal *= 1.2;
        }

        if (atencion.getTipoConsulta() == TipoConsulta.URGENCIA){
            costoFinal *= 1.5;
        }

        return costoFinal;
    }

    public double estimarDosisMedicamento (String codigoMascota, double dosisBase){
        Mascota mascota = obtenerMascota(codigoMascota);
        double pesoMascota = mascota.getPeso();
        return dosisBase * pesoMascota;
    }

    public String sugerirProximaFechaVacuna(String codigoMascota){
        Mascota mascota = obtenerMascota(codigoMascota);
        LocalDate fechaActual = LocalDate.now();
        LocalDate proximaVacuna;
        String fecha = "Fecha próxima vacuna: ";
        if (mascota.getEspecie()== Especie.PERRO || mascota.getEspecie()== Especie.GATO){
            proximaVacuna = fechaActual.plusMonths(12);
            fecha += proximaVacuna;
        } else if (mascota.getEspecie()== Especie.AVE){
            proximaVacuna = fechaActual.plusMonths(8);
            fecha += proximaVacuna;
        } else {
            proximaVacuna = fechaActual.plusMonths(18);
            fecha += proximaVacuna;
        }
        return fecha;
    }

    public int calcularPrioridad (String numeroAtencion){
        AtencionMedica atencion = obtenerAtencion(numeroAtencion);
        TipoConsulta tipoConsulta = atencion.getTipoConsulta();

        switch (tipoConsulta){
            case URGENCIA:
                return 4;
            case VACUNACION:
                return 3;
            case GENERAL:
                return 2;
            case CONTROL:
                return 1;
            default:
                return 0;
            }
    }

    public boolean validarId(String id) {
            if (id == null) {
                return false;
            }
            id = id.trim();
            if (id.isEmpty()) {
                return false;
            }
            return id.length() >= 8;
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
    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listPropietarios;
    }

    public ArrayList<Mascota> obtenerListaMascotas() {
        return listMascotas;
    }

    public ArrayList<AtencionMedica> obtenerListaAtenciones() {
        return listAtenciones;
    }

    // To String
    public String toString() {
        return "Veterinaria{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
