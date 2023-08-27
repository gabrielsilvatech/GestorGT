package br.com.gt.gestor.model.produto;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cor;
    private BigDecimal valor;

    public Produto (DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.cor = dados.cor();
        this.valor = dados.valor();
    }

    public Produto (){}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", valor=" + valor +
                '}';
    }
}
