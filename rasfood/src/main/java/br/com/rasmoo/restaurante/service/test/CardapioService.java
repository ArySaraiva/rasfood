package br.com.rasmoo.restaurante.service.test;



import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Pesquisa de produto por nome: "+ cardapioDao.colsultaPorNome("m8oqueca"));
        entityManager.close();
    }
}