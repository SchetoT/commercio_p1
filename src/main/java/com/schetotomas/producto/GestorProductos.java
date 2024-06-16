package com.schetotomas.producto;

import com.schetotomas.GestorGenerico;
import jakarta.persistence.*;

import java.util.List;

public class GestorProductos {
    public void createProducto(String description, String code, Integer stock, Double price){
        EntityManager entityManager = null;
        try {
            entityManager = GestorGenerico.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = new Producto(description, code, stock, price);
            entityManager.persist(producto);
            transaction.commit();
            System.out.println("Producto creado exitosamente: " + producto);
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error al crear el producto: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public List<Producto> readAll() {
        EntityManager entityManager = null;
        try {
            entityManager = GestorGenerico.getEntityManager();
            return entityManager.createQuery("FROM Producto", Producto.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar productos: " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Producto readById(Integer id) {
        EntityManager entityManager = null;
        try {
            entityManager = GestorGenerico.getEntityManager();
            return entityManager.find(Producto.class, id);
        } catch (Exception e) {
            System.err.println("Error al buscar producto por ID: " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void update(Integer id, String code, Integer stock, Double price) {
        EntityManager entityManager = null;
        try {
            entityManager = GestorGenerico.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null) {
                if (code != null) {
                    producto.setCode(code);
                }
                if (stock != null) {
                    producto.setStock(stock);
                }
                if (price != null) {
                    producto.setPrice(price);
                }
                entityManager.merge(producto);
                transaction.commit();
                System.out.println("Producto actualizado exitosamente: " + producto);
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = null;
        try {
            entityManager = GestorGenerico.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null) {
                entityManager.remove(producto);
                transaction.commit();
                System.out.println("Producto eliminado exitosamente: " + producto);
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    }
        /*
        EntityManager manager =GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = new Producto(description, code, stock, price);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();

    }

    public List<Producto> readAll(){
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Producto> lista = manager.createQuery("FROM Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }
    public Producto readById(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        Producto producto = entityManager.find(Producto.class, id);
        entityManager.close();
        return producto;
    }

    public void update(Integer id, String code, Integer stock, Double price) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            if (code != null) { producto.setCode(code); }
            if (stock != null) { producto.setStock(stock); }
            if (price != null) { producto.setPrice(price); }
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
    public void delete(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }*/
