package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ordem ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;

    @Column(name = "Valor_de_registro")
    private BigDecimal valorDeResgistro;

    private Integer quantidade;

    public OrdensCardapio() {
    }

    public OrdensCardapio(Integer quantidade, Cardapio cardapio) {
        this.quantidade = quantidade;
        this.cardapio = cardapio;
        this.valorDeResgistro = cardapio.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public BigDecimal getValorDeResgistro() {
        return valorDeResgistro;
    }

    public void setValorDeResgistro(BigDecimal valorDeResgistro) {
        this.valorDeResgistro = valorDeResgistro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", cardapio=" + cardapio +
                ", valorDeResgistro=" + valorDeResgistro +
                ", quantidade=" + quantidade +
                '}';
    }
}
