package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.Produto;

public class ProdutoDao {
    
    private EntityManager em;

    

    public ProdutoDao() {
    }

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }
    
    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
            return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
            return em.createQuery(jpql, Produto.class)
            .setParameter("nome", nome)
            .getResultList();
    }

    public List<Produto> buscarNomeCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
            return em.createQuery(jpql, Produto.class)
            .setParameter("nome", nome)
            .getResultList();
    }

    public BigDecimal buscarPrecoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
            return em.createQuery(jpql, BigDecimal.class)
            .setParameter("nome", nome)
            .getSingleResult();
    }
}
