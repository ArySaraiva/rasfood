package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDAO {
    private EntityManager entityManager;

    public PratoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: " + prato );
    }
}
