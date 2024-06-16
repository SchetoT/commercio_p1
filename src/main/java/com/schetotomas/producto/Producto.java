package com.schetotomas.producto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String code;
    private Integer stock;
    private Double price;

    public Producto(){}

    public Producto(String description, String code, Integer stock, Double price) {
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(description, producto.description) && Objects.equals(code, producto.code) && Objects.equals(stock, producto.stock) && Objects.equals(price, producto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, code, stock, price);
    }
}
