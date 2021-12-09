package com.DiegoDegracia.Modelos;

import java.util.Objects;

public class Atraccion {
    // Propiedades del objeto
    private int ID;
    private String Nombre;
    private Integer Costo;
    private Double TiempoPromedio;
    private Integer Cupo;
    private TipoAventura Tipo;

    // Constructor del objeto
    public Atraccion(int id, String nombre, Integer costo, Double tiempoPromedio, Integer cupo, TipoAventura tipo) {
        ID = id;
        Nombre = nombre;
        Costo = costo;
        TiempoPromedio = tiempoPromedio;
        Cupo = cupo;
        Tipo = tipo;
    }

    // Métodos del objeto.
    public int getID(){ return ID; }
    public String getNombre() {
        return Nombre;
    }

    public Integer getCosto() {
        return Costo;
    }

    public Double getTiempoPromedio() {
        return TiempoPromedio;
    }

    public Integer getCupo() {
        return Cupo;
    }

    public TipoAventura getTipo() {
        return Tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atraccion atraccion = (Atraccion) o;
        return Nombre.equals(atraccion.Nombre) && Tipo == atraccion.Tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Tipo);
    }
}
