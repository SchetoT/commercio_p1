package com.schetotomas.cliente;

import com.schetotomas.Carro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private Integer docnumber;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carro> carro = new ArrayList<>();
    public Cliente() {}
    public Cliente(String name, String lastname, Integer docnumber) {
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(Integer docnumber) {
        this.docnumber = docnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(name, cliente.name) && Objects.equals(lastname, cliente.lastname) && Objects.equals(docnumber, cliente.docnumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, docnumber);
    }
}
