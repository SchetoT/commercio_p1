package com.schetotomas.cliente;

import com.schetotomas.GestorGenerico;
import jakarta.persistence.*;

import java.util.List;

public class GestorClientes {
    public void createCliente(String name, String lastname, Integer docnumber) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Cliente cliente = new Cliente(name, lastname, docnumber);
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            System.out.println("Cliente creado" + cliente);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error al crear el cliente: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Cliente> listClientes() {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        try {
            return entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateCliente(Cliente cliente) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
            System.out.println("Cliente actualizado exitosamente: " + cliente);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void deleteCliente(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, id);
            if (cliente != null) {
                entityManager.remove(cliente);
                System.out.println("Cliente eliminado exitosamente: " + cliente);
            } else {
                System.out.println("Cliente no encontrado con id: " + id);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
        } finally {
            entityManager.close();
        }



    /*public void createCliente(String name, String lastname, Integer docnumber){
        EntityManager manager =GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente(name, lastname, docnumber);
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();

    }

    public List<Cliente> readAll(){
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = manager.createQuery("FROM Cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }
    public Cliente readById(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.close();
        return cliente;
    }

    public void update(Integer id, String name, String lastname) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            if (name != null) { cliente.setName(name); }
            if (lastname != null) { cliente.setLastname(lastname); }
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
    public void delete(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }*/
    }
}





