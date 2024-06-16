package com.schetotomas;

import com.schetotomas.cliente.GestorClientes;
import com.schetotomas.producto.GestorProductos;

public class Pruebas {
    public static void main(String[]args){
        GestorProductos gestorProductos = new GestorProductos();
        GestorClientes gestorClientes = new GestorClientes();
        gestorProductos.createProducto("Telefono","TS001",10,300.0);
        gestorProductos.createProducto("Tablet","TS002",7,500.0);
        gestorProductos.createProducto("Mouse","TS003",20,50.0);
        gestorProductos.createProducto("Monitor","TS004",5,400.0);
        gestorClientes.createCliente("Tomas","Scheto",42109200);
        gestorClientes.createCliente("Lionel","Messi",30155001);
        gestorClientes.createCliente("Itachi","Uchiha",38788666);


    }


}
