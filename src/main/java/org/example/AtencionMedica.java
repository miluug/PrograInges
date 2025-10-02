package org.example;

import java.time.LocalDate;

public class AtencionMedica {
   private String numeroAtencion;
   private LocalDate fecha;
   private Mascota mascota;
   private TipoConsulta tipoConsulta;
   private double valorBase;
   private double costoFinal;

    public AtencionMedica(String numeroAtencion, LocalDate fecha, Mascota mascota, TipoConsulta tipoConsulta, double valorBase) {
        this.numeroAtencion = numeroAtencion;
        this.fecha = fecha;
        this.mascota = mascota;
        this.tipoConsulta = tipoConsulta;
        this.valorBase = valorBase;
        this.costoFinal = valorBase;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumeroAtencion() {
        return numeroAtencion;
    }

    public void setNumeroAtencion(String numeroAtencion) {
        this.numeroAtencion = numeroAtencion;
    }
}
