package com.schetotomas;

import com.schetotomas.cliente.Cliente;
import com.schetotomas.producto.Producto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name ="cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name ="producto_id", nullable = false)
    private Producto producto;

    public Carro(){}

    public Carro(Integer id, Double price, Integer amount, Cliente cliente, Producto producto) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.cliente = cliente;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(price, carro.price) && Objects.equals(amount, carro.amount) && Objects.equals(cliente, carro.cliente) && Objects.equals(producto, carro.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, amount, cliente, producto);
    }
}
