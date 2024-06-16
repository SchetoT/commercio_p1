package com.schetotomas.comprobante;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column
    private String tipo;
    public Comprobante(){}

    public Comprobante(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return Objects.equals(id, that.id) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }
    @Override
    public String toString() {
        return "Comprobante{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
