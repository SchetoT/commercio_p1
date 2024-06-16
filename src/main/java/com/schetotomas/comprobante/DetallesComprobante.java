package com.schetotomas.comprobante;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class DetallesComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer cantidad;
    @Column
    private Double precioUnitario;
    public DetallesComprobante(){}

    public DetallesComprobante(Integer id, Integer cantidad, Double precioUnitario) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallesComprobante that = (DetallesComprobante) o;
        return Objects.equals(id, that.id) && Objects.equals(cantidad, that.cantidad) && Objects.equals(precioUnitario, that.precioUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, precioUnitario);
    }
    @Override
    public String toString() {
        return "DetalleComprobante{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
