package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "Ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column (name = "data_de_criacao")
    private LocalDateTime dateDeCriacao;

    @ManyToOne
    private Cliente cliente;

    public Ordem() {
    }

    public Ordem(BigDecimal valorTotal, LocalDateTime dateDeCriacao, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.dateDeCriacao = dateDeCriacao;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDateDeCriacao() {
        return dateDeCriacao;
    }

    public void setDateDeCriacao(LocalDateTime dateDeCriacao) {
        this.dateDeCriacao = dateDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dateDeCriacao=" + dateDeCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
