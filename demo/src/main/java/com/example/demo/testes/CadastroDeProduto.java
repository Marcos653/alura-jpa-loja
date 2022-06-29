package com.example.demo.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.Categoria;
import com.example.demo.Produto;
import com.example.demo.dao.CategoriaDao;
import com.example.demo.dao.ProdutoDao;
import com.example.demo.util.JPAUtil;

public class CadastroDeProduto {
    
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        List<Produto> filter = produtoDao.buscarNome("Xiaomi Redmi");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal filters = produtoDao.buscarPrecoComNome("Xiaomi Redmi");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        List<Produto> filterCategoria = produtoDao.buscarNomeCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

    }


    private static void cadastrarProduto(){
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
        // Categoria celulares = new Categoria("Celulares");
        // // Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);


        // EntityManager em = JPAUtil.getEntityManager(); 
        // // ProdutoDao dao = new ProdutoDao(em);
        // // CategoriaDao daos = new CategoriaDao(em);


        // em.getTransaction().begin();

        // em.persist(celulares);
        // celulares.setNome("XP4");

        // // daos.cadastrar(celulares);
        // // dao.cadastrar(celular);

        // em.flush();
        // em.clear();

        // celulares = em.merge(celulares);
        // celulares.setNome("1234");
        // // em.flush();
        // // em.remove(celulares);
        // em.flush();
    
}
