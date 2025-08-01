package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.ClienteId;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.consultarClientes(null, null, "lapa"));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null, null, "lapa"));

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorId(new ClienteId("tayane@email.com","111111111123")));

        entityManager.getTransaction().commit();

        entityManager.close();


    }
}
