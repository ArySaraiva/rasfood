package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("78035610", "Rua professora Neuza Lula Rodrigues", "Barra do Pari"," Cuiabá", "MT");
        Cliente felipe = new Cliente("02152289102", "Felipe" );
        felipe.addEndereco(endereco);
        Ordem ordem = new Ordem(felipe);
        ordem.addOrdemCardapio(new OrdensCardapio(2, cardapioDao.consultarPorId(1)));
        ordem.addOrdemCardapio(new OrdensCardapio(3, cardapioDao.consultarPorId(2)));
        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
