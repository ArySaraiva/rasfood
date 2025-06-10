package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setName("Risoto de frutos do mar");
        risoto.setDescricao("Risoto de frutos do mar: acompanhado de Lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}