package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.PratoDAO;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

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


        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDAO pratoDAO = new PratoDAO(entityManager);
        entityManager.getTransaction().begin();
        pratoDAO.cadastrar(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}