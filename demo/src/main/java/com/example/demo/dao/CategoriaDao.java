package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.Categoria;
import com.example.demo.Produto;


public class CategoriaDao {
    
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }

    public void remove(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }

    public Categoria buscarPorId(long id) {
        return em.find(Categoria.class, id);
    }

    public List<Categoria> buscarTodos(){
        String jpql = "SELECT p FROM Categoria p";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }
}
